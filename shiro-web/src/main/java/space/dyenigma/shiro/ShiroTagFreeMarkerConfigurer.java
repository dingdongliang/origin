package space.dyenigma.shiro;

import java.io.IOException;

import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import space.dyenigma.shiro.tag.ShiroTags;

import freemarker.template.TemplateException;

/**
 * origin/space.dyenigma.shiro
 *
 * @Description :
 * @Author : dingdongliang
 * @Date : 2018/2/15 8:53
 */
public class ShiroTagFreeMarkerConfigurer extends FreeMarkerConfigurer {
    @Override
    public void afterPropertiesSet() throws IOException, TemplateException {
        super.afterPropertiesSet();
        this.getConfiguration().setSharedVariable("shiro", new ShiroTags());
    }
}