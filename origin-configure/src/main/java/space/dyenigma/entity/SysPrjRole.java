package space.dyenigma.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "sys_prj_role")
public class SysPrjRole extends BaseDomain {
    /**
     * 项目组角色配置自增ID
     */
    @Id
    @Column(name = "PR_ID")
    private String prId;

    /**
     * 项目组ID
     */
    @Column(name = "PRJ_ID")
    private String prjId;

    /**
     * 角色ID
     */
    @Column(name = "ROLE_ID")
    private String roleId;

    /**
     * 当前状态,E:有效的,I:无效的
     */
    @Column(name = "STATUS")
    private String status;

    /**
     * 获取项目组角色配置自增ID
     *
     * @return PR_ID - 项目组角色配置自增ID
     */
    public String getPrId() {
        return prId;
    }

    /**
     * 设置项目组角色配置自增ID
     *
     * @param prId 项目组角色配置自增ID
     */
    public void setPrId(String prId) {
        this.prId = prId;
    }

    /**
     * 获取项目组ID
     *
     * @return PRJ_ID - 项目组ID
     */
    public String getPrjId() {
        return prjId;
    }

    /**
     * 设置项目组ID
     *
     * @param prjId 项目组ID
     */
    public void setPrjId(String prjId) {
        this.prjId = prjId;
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