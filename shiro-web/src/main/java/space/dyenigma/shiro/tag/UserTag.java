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
 * @Date : 2018/2/15 8:50
 */
public class UserTag extends SecureTag {

    private static final Logger logger = LoggerFactory.getLogger(UserTag.class);

    @Override
    public void render(Environment env, Map params, TemplateDirectiveBody body) throws IOException, TemplateException {
        if (getSubject() != null && getSubject().getPrincipal() != null) {
            logger.debug("Subject has known identity (aka 'principal'). Tag body will be evaluated.");
            renderBody(env, body);
        } else {
            logger.debug(
                    "Subject does not exist or have a known identity (aka 'principal'). Tag body will not be evaluated.");
        }
    }
}
