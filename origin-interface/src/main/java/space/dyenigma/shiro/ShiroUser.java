package space.dyenigma.shiro;

import space.dyenigma.entity.BaseDomain;

import java.io.Serializable;

/**
 * origin/space.dyenigma.shiro
 *
 * @Description: 登录用户权限
 * @Author: dingdongliang
 * @Date: 2015年9月14日 下午6:06:07
 */
public class ShiroUser extends BaseDomain implements Serializable {

    private static final long serialVersionUID = 1L;
    private String userId;
    private String account;

    public ShiroUser(String userId, String account) {
        super();
        this.userId = userId;
        this.account = account;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
