package space.dyenigma.shiro.tag;

/**
 * origin/space.dyenigma.shiro.tag
 *
 * @Description :
 * @Author : dingdongliang
 * @Date : 2018/2/15 8:42
 */
public class LacksRoleTag extends RoleTag {
    protected boolean showTagBody(String roleName) {
        boolean hasRole = getSubject() != null && getSubject().hasRole(roleName);
        return !hasRole;
    }
}
