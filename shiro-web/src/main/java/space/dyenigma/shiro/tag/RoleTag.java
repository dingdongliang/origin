package space.dyenigma.shiro.tag;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.util.Map;

/**
 * origin/space.dyenigma.shiro.tag
 *
 * @Description :
 * @Author : dingdongliang
 * @Date : 2018/2/15 8:43
 */
public abstract class RoleTag extends SecureTag {
    String getName(Map params) {
        return getParam(params, "name");
    }

    @Override
    public void render(Environment env, Map params, TemplateDirectiveBody body) throws IOException, TemplateException {
        boolean show = showTagBody(getName(params));
        if (show) {
            renderBody(env, body);
        }
    }

    protected abstract boolean showTagBody(String roleName);
}