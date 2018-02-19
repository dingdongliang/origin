package space.dyenigma.configure.shiro;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import space.dyenigma.configure.shiro.annotation.SessionUserArgumentResolver;

import java.util.List;

/**
 * origin/space.dyenigma.configure.shiro
 *
 * @Description:
 * @Author: dingdongliang
 * @Date: 2018/2/14 21:12
 */
@Configuration
public class ShiroWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new SessionUserArgumentResolver());
    }

}
