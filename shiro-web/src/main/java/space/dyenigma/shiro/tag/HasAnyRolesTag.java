package space.dyenigma.shiro.tag;

import org.apache.shiro.subject.Subject;

/**
 * origin/space.dyenigma.shiro.tag
 *
 * @Description :
 * @Author : dingdongliang
 * @Date : 2018/2/15 8:41
 */
public class HasAnyRolesTag extends RoleTag {

    private static final String ROLE_NAMES_DELIMETER = ",";

    protected boolean showTagBody(String roleNames) {
        boolean hasAnyRole = false;
        Subject subject = getSubject();

        if (subject != null) {

            for (String role : roleNames.split(ROLE_NAMES_DELIMETER)) {
                if (subject.hasRole(role.trim())) {
                    hasAnyRole = true;
                    break;
                }
            }
        }

        return hasAnyRole;
    }
}