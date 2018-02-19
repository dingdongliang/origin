package space.dyenigma.shiro;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * origin/space.dyenigma.shiro
 *
 * @Description: 给用户添加role时使用
 * @Author: dingdongliang
 * @Date: 2018/2/14 19:17
 */
@Slf4j
@Data
public class UserRoleListCheck {

    private String username;
    private String roleName;
    private boolean check = false;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
