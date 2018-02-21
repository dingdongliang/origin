package space.dyenigma.shiro;

import space.dyenigma.entity.SysPermission;
import space.dyenigma.entity.SysUser;
import space.dyenigma.service.ISysPermissionService;
import space.dyenigma.service.ISysUserService;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * origin/space.dyenigma.shiro
 *
 * @Description: 自定义的指定Shiro验证用户登录的类
 * @Author: dingdongliang
 * @Date: 2015年9月8日 下午12:01:00
 */
public class LoginRealm extends AuthorizingRealm {

    private final Logger logger = LoggerFactory.getLogger(LoginRealm.class);

    private static final String ALGORITHM = "MD5";

    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private ISysPermissionService sysPermissionService;

    public LoginRealm() {
        super();
    }

    /**
     * @param authcToken
     * @return org.apache.shiro.authc.AuthenticationInfo
     * @Description : 验证当前登录的Subject 本例中该方法的调用时机为LoginController.login()方法中执行Subject.login()时
     * @author dingdongliang
     * @date 2018/2/20 18:11
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
            throws AuthenticationException {

        // 这个authcToken是从LoginController里面currentUser.login(token)传过来的
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        logger.debug("验证当前Subject时获取到token为"
                + ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));
        SysUser sysUser = sysUserService.getUserByName(token.getUsername());

        // Shiro完成对比逻辑,返回和令牌相关的正确的验证信息，第一个参数填登录用户名,第二个参数填合法的登录密码
        if (sysUser != null) {
            ShiroUser shiroUser = new ShiroUser(sysUser.getUserId(), sysUser.getAccount());
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(shiroUser,
                    sysUser.getPassword(), getName());
            this.setSession("shiroUser", shiroUser);
            return authcInfo;
        } else {
            throw new AuthenticationException();
        }

        // 没有返回登录用户名对应的SimpleAuthenticationInfo对象时,就会在LoginController中抛出UnknownAccountException异常

    }

    /**
     * 为当前登录的Subject授予角色和权限 ,该方法的调用时机为需授权资源被访问时
     * 并且每次访问需授权资源时都会执行该方法中的逻辑,这表明本例中默认并未启用AuthorizationCache
     * 个人感觉若使用了Spring3.1开始提供的ConcurrentMapCache支持,则可灵活决定是否启用AuthorizationCache
     * 比如说这里从数据库获取权限信息时,先去访问Spring3.1提供的缓存,而不使用Shior提供的AuthorizationCache
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        ShiroUser shiroUser = (ShiroUser) principals.fromRealm(getName()).iterator().next();
        String username = shiroUser.getAccount();
        if (username != null) {
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

            // 查询用户授权信息
            List<SysPermission> perList = sysPermissionService.getShiro("O");

            if (perList != null && perList.size() != 0) {
                for (SysPermission sysPermission : perList) {
                    info.addStringPermission(sysPermission.getPmsnCode());
                }
                return info;
            }
        }
        return null;
    }

    /**
     * 更新用户授权信息缓存.
     */
    public void clearCachedAuthorizationInfo(String principal) {
        SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());
        clearCachedAuthorizationInfo(principals);
    }

    /**
     * 清除所有用户授权信息缓存.
     */
    public void clearAllCachedAuthorizationInfo() {
        Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
        if (cache != null) {
            for (Object key : cache.keys()) {
                cache.remove(key);
            }
        }
    }

    @PostConstruct
    public void initCredentialsMatcher() {// MD5加密
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(ALGORITHM);
        matcher.setStoredCredentialsHexEncoded(true);
        setCredentialsMatcher(matcher);
    }

    /**
     * 将一些数据放到ShiroSession中,以便于其它地方使用
     * <p>
     * 比如Controller,使用时直接用HttpSession.getAttribute(key)就可以取到
     */
    private void setSession(Object key, Object value) {
        Subject subject = SecurityUtils.getSubject();
        if (null != subject) {
            Session session = subject.getSession();
            logger.debug("Session默认超时时间为[" + session.getTimeout() + "]毫秒");
            if (null != session) {
                session.setAttribute(key, value);
            }
        }
    }
}
