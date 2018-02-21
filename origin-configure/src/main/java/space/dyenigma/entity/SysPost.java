package space.dyenigma.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "sys_post")
public class SysPost extends BaseDomain {
    /**
     * 岗位自增ID
     */
    @Id
    @Column(name = "POST_ID")
    private String postId;

    /**
     * 岗位名称
     */
    @Column(name = "POST_NAME")
    private String postName;

    /**
     * 部门ID
     */
    @Column(name = "DIV_ID")
    private String divId;

    /**
     * 备注
     */
    @Column(name = "POST_DESC")
    private String postDesc;

    /**
     * 当前状态,E:有效的,I:无效的
     */
    @Column(name = "STATUS")
    private String status;

    /**
     * 获取岗位自增ID
     *
     * @return POST_ID - 岗位自增ID
     */
    public String getPostId() {
        return postId;
    }

    /**
     * 设置岗位自增ID
     *
     * @param postId 岗位自增ID
     */
    public void setPostId(String postId) {
        this.postId = postId;
    }

    /**
     * 获取岗位名称
     *
     * @return POST_NAME - 岗位名称
     */
    public String getPostName() {
        return postName;
    }

    /**
     * 设置岗位名称
     *
     * @param postName 岗位名称
     */
    public void setPostName(String postName) {
        this.postName = postName;
    }

    /**
     * 获取部门ID
     *
     * @return DIV_ID - 部门ID
     */
    public String getDivId() {
        return divId;
    }

    /**
     * 设置部门ID
     *
     * @param divId 部门ID
     */
    public void setDivId(String divId) {
        this.divId = divId;
    }

    /**
     * 获取备注
     *
     * @return POST_DESC - 备注
     */
    public String getPostDesc() {
        return postDesc;
    }

    /**
     * 设置备注
     *
     * @param postDesc 备注
     */
    public void setPostDesc(String postDesc) {
        this.postDesc = postDesc;
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