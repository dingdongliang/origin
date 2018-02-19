package space.dyenigma.shiro.tag;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

/**
 * origin/space.dyenigma.shiro.tag
 *
 * @Description :
 * @Author : dingdongliang
 * @Date : 2018/2/15 8:42
 */
public class NotAuthenticatedTag extends SecureTag {
    private static final Logger logger = LoggerFactory.getLogger(NotAuthenticatedTag.class);

    @Override
    public void render(Environment env, Map params, TemplateDirectiveBody body) throws IOException, TemplateException {
        if (getSubject() == null || !getSubject().isAuthenticated()) {
            logger.debug("Subject does not exist or is not authenticated.  Tag body will be evaluated.");
            renderBody(env, body);
        } else {
            logger.debug("Subject exists and is authenticated.  Tag body will not be evaluated.");
        }
    }
}