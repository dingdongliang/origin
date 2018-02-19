package space.dyenigma.shiro.tag;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.subject.PrincipalCollection;

import freemarker.core.Environment;
import freemarker.log.Logger;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;

/**
 * origin/space.dyenigma.shiro.tag
 *
 * @Description :
 * @Author : dingdongliang
 * @Date : 2018/2/15 8:43
 */
public class UsernameTag extends SecureTag {

    @Override
    public void render(Environment env, Map params, TemplateDirectiveBody body) throws IOException, TemplateException {
        String result = null;

        if (getSubject() != null) {
            PrincipalCollection pcpls = getSubject().getPrincipals();
            Set<String> set = pcpls.getRealmNames();
            Iterator<String> it = set.iterator();
            if (it.hasNext()) {
                result = it.next();
            }
        }

        if (result != null) {
            try {
                env.getOut().write(result);
            } catch (IOException ex) {
                throw new TemplateException("Error writing [" + result + "] to Freemarker.", ex, env);
            }
        }
    }
}