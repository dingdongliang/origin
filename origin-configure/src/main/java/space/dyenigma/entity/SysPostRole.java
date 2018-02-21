package space.dyenigma.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "sys_post_role")
public class SysPostRole extends BaseDomain {
    /**
     * 岗位角色配置自增ID
     */
    @Id
    @Column(name = "PR_ID")
    private String prId;

    /**
     * 角色ID
     */
    @Column(name = "ROLE_ID")
    private String roleId;

    /**
     * 岗位ID
     */
    @Column(name = "POST_ID")
    private String postId;

    /**
     * 当前状态,E:有效的,I:无效的
     */
    @Column(name = "STATUS")
    private String status;

    /**
     * 获取岗位角色配置自增ID
     *
     * @return PR_ID - 岗位角色配置自增ID
     */
    public String getPrId() {
        return prId;
    }

    /**
     * 设置岗位角色配置自增ID
     *
     * @param prId 岗位角色配置自增ID
     */
    public void setPrId(String prId) {
        this.prId = prId;
    }

    /**
     * 获取角色ID
     *
     * @return ROLE_ID - 角色ID
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * 设置角色ID
     *
     * @param roleId 角色ID
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取岗位ID
     *
     * @return POST_ID - 岗位ID
     */
    public String getPostId() {
        return postId;
    }

    /**
     * 设置岗位ID
     *
     * @param postId 岗位ID
     */
    public void setPostId(String postId) {
        this.postId = postId;
    }

    /**
     * 获取当前状态,E:有效的,I:无效的
     *
     * @return STATUS - 当前状态,E:有效的,I:无效的
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置当前状态,E:有效的,I:无效的
     *
     * @param status 当前状态,E:有效的,I:无效的
     */
    public void setStatus(String status) {
        this.status = status;
    }

}