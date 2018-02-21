package space.dyenigma.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "sys_role_pmsn")
public class SysRolePmsn extends BaseDomain {
    /**
     * 权限角色配置自增ID
     */
    @Id
    @Column(name = "RP_ID")
    private String rpId;

    /**
     * 角色ID
     */
    @Column(name = "ROLE_ID")
    private String roleId;

    /**
     * 权限ID
     */
    @Column(name = "PMSN_ID")
    private String pmsnId;

    /**
     * 当前状态,E:有效的,I:无效的
     */
    @Column(name = "STATUS")
    private String status;

    /**
     * 获取权限角色配置自增ID
     *
     * @return RP_ID - 权限角色配置自增ID
     */
    public String getRpId() {
        return rpId;
    }

    /**
     * 设置权限角色配置自增ID
     *
     * @param rpId 权限角色配置自增ID
     */
    public void setRpId(String rpId) {
        this.rpId = rpId;
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
     * 获取权限ID
     *
     * @return PMSN_ID - 权限ID
     */
    public String getPmsnId() {
        return pmsnId;
    }

    /**
     * 设置权限ID
     *
     * @param pmsnId 权限ID
     */
    public void setPmsnId(String pmsnId) {
        this.pmsnId = pmsnId;
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