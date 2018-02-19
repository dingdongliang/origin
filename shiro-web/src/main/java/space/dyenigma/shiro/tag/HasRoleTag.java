package space.dyenigma.shiro.tag;

/**
 * origin/space.dyenigma.shiro.tag
 *
 * @Description :
 * @Author : dingdongliang
 * @Date : 2018/2/15 8:42
 */
public class HasRoleTag extends RoleTag {
    protected boolean showTagBody(String roleName) {
        return getSubject() != null && getSubject().hasRole(roleName);
    }
}
