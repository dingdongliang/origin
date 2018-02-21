package space.dyenigma.configure.druid;

import com.alibaba.druid.support.spring.stat.DruidStatInterceptor;
import org.springframework.aop.Advisor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * origin/space.dyenigma.configure.druid
 *
 * @Description: Druid监控spring jdbc配置
 * @Author: dingdongliang
 * @Date: 2017/7/26 9:02
 */
@Configuration
public class DruidConfigurer {

    /**
     * @param
     * @return com.alibaba.druid.support.spring.stat.DruidStatInterceptor
     * @Description : 定义监听Spring拦截器
     * @author dingdongliang
     * @date 2018/2/20 17:51
     */
    @Bean
    public DruidStatInterceptor druidStatInterceptor() {
        return new DruidStatInterceptor();
    }

    /**
     * @param
     * @return org.springframework.aop.support.JdkRegexpMethodPointcut
     * @Description : 定义监听Spring切入点
     * @author dingdongliang
     * @date 2018/2/20 17:51
     */
    @Bean
    public JdkRegexpMethodPointcut druidStatPointcut() {
        JdkRegexpMethodPointcut druidStatPointcut = new JdkRegexpMethodPointcut();
        String patterns = "space.dyenigma.*.*.service.*";
        String patterns2 = "space.dyenigma.*.*.dao.*";
        druidStatPointcut.setPatterns(patterns, patterns2);
        return druidStatPointcut;
    }

    /**
     * @param
     * @return org.springframework.aop.Advisor
     * @Description : 定义监听Spring通知类
     * @author dingdongliang
     * @date 2018/2/20 17:51
     */
    @Bean
    public Advisor druidStatAdvisor() {
        return new DefaultPointcutAdvisor(druidStatPointcut(), druidStatInterceptor());
    }
}
