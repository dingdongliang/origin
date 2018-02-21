package space.dyenigma.util;

import space.dyenigma.shiro.LoginRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.RealmSecurityManager;

/**
 * origin/space.dyenigma.util
 *
 * @Description: 刷新用户权限缓存类
 * @Author: dingdongliang
 * @Date: 2016/4/2 18:47
 */
public class ShiroUtil {
    /**
     * @param
     * @return void
     * @Description : 更改权限后，调用该方法刷新用户权限缓存,在涉及权限变换控制器里调用
     * @author dingdongliang
     * @date 2018/2/20 19:42
     */
    public static void refreshRealm() {
        RealmSecurityManager securityManager =
                (RealmSecurityManager) SecurityUtils.getSecurityManager();
        LoginRealm userRealm = (LoginRealm) securityManager.getRealms().iterator().next();
        userRealm.clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipal().toString());
    }
}
