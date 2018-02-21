package space.dyenigma.shiro;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * origin/space.dyenigma.shiro
 *
 * @Description:
 * @Author: dingdongliang
 * @Date: 2017/7/21 8:40
 */
@Configuration
public class ShiroConfigurer {

    private Logger logger = LoggerFactory.getLogger(ShiroConfigurer.class);

    /**
     * ShiroFilterFactoryBean 处理拦截资源文件问题。
     * 注意：单独一个ShiroFilterFactoryBean配置是或报错的，因为在
     * 初始化ShiroFilterFactoryBean的时候需要注入：SecurityManager
     * Filter Chain定义说明
     * 1、一个URL可以配置多个Filter，使用逗号分隔
     * 2、当设置多个过滤器时，全部验证通过，才视为通过
     * 3、部分过滤器可指定参数，如perms，roles
     */
    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        shiroFilterFactoryBean.setSecurityManager(securityManager); // 必须设置 SecurityManager

        shiroFilterFactoryBean.setLoginUrl("/login");  // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setSuccessUrl("/index"); // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");// 未授权界面

        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();

        // 配置不会被拦截的链接 顺序判断,authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问
        filterChainDefinitionMap.put("/manage/ckeditor/**", "anon");
        filterChainDefinitionMap.put("/manage/css/**", "anon");
        filterChainDefinitionMap.put("/manage/fonts/**", "anon");
        filterChainDefinitionMap.put("/manage/iCheck/**", "anon");
        filterChainDefinitionMap.put("/manage/images/**", "anon");
        filterChainDefinitionMap.put("/manage/js/**", "anon");

        filterChainDefinitionMap.put("/captcha", "anon");
        filterChainDefinitionMap.put("/favicon.ico", "anon");
        filterChainDefinitionMap.put("/login", "anon");
        filterChainDefinitionMap.put("/enter", "anon");
        filterChainDefinitionMap.put("/front/**", "anon");
        filterChainDefinitionMap.put("/index", "anon");
        filterChainDefinitionMap.put("/logout", "logout");// 配置退出过滤器,其中的具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/**", "authc"); // 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        logger.debug("Shiro拦截器工厂类注入成功");
        return shiroFilterFactoryBean;
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 设置realm.
        securityManager.setRealm(myShiroRealm());
        return securityManager;
    }

    /**
     * @param
     * @return space.dyenigma.shiro.LoginRealm
     * @Description : 身份认证realm; (这个需要自己写，账号密码校验；权限等)
     * @author dingdongliang
     * @date 2018/2/20 18:14
     */
    @Bean
    public LoginRealm myShiroRealm() {
        LoginRealm loginRealm = new LoginRealm();
        return loginRealm;
    }
}

