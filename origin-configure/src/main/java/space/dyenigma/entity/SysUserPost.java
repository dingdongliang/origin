package space.dyenigma.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "sys_user_post")
public class SysUserPost extends BaseDomain {
    /**
     * 用户岗位配置自增ID
     */
    @Id
    @Column(name = "UP_ID")
    private String upId;

    /**
     * 角色ID
     */
    @Column(name = "USER_ID")
    private String userId;

    /**
     * 权限ID
     */
    @Column(name = "POST_ID")
    private String postId;

    /**
     * 当前状态,E:有效的,I:无效的
     */
    @Column(name = "STATUS")
    private String status;

    /**
     * 获取用户岗位配置自增ID
     *
     * @return UP_ID - 用户岗位配置自增ID
     */
    public String getUpId() {
        return upId;
    }

    /**
     * 设置用户岗位配置自增ID
     *
     * @param upId 用户岗位配置自增ID
     */
    public void setUpId(String upId) {
        this.upId = upId;
    }

    /**
     * 获取角色ID
     *
     * @return USER_ID - 角色ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置角色ID
     *
     * @param userId 角色ID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取权限ID
     *
     * @return POST_ID - 权限ID
     */
    public String getPostId() {
        return postId;
    }

    /**
     * 设置权限ID
     *
     * @param postId 权限ID
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