package space.dyenigma.shiro.tag;

/**
 * origin/space.dyenigma.shiro.tag
 *
 * @Description :
 * @Author : dingdongliang
 * @Date : 2018/2/15 8:42
 */
public class LacksPermissionTag extends PermissionTag {
    protected boolean showTagBody(String p) {
        return !isPermitted(p);
    }
}
