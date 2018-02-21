package space.dyenigma.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "sys_role")
public class SysRole extends BaseDomain {
    /**
     * 角色自增ID
     */
    @Id
    @Column(name = "ROLE_ID")
    private String roleId;

    /**
     * 角色名称
     */
    @Column(name = "ROLE_NAME")
    private String roleName;

    /**
     * 角色描述
     */
    @Column(name = "ROLE_DESC")
    private String roleDesc;

    /**
     * 排序列
     */
    @Column(name = "SORT")
    private Integer sort;

    /**
     * 当前状态,E:有效的,I:无效的
     */
    @Column(name = "STATUS")
    private String status;

    /**
     * 是否默认角色
     */
    @Column(name = "IS_DEFAULT")
    private String isDefault;

    /**
     * 获取角色自增ID
     *
     * @return ROLE_ID - 角色自增ID
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * 设置角色自增ID
     *
     * @param roleId 角色自增ID
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取角色名称
     *
     * @return ROLE_NAME - 角色名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置角色名称
     *
     * @param roleName 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * 获取角色描述
     *
     * @return ROLE_DESC - 角色描述
     */
    public String getRoleDesc() {
        return roleDesc;
    }

    /**
     * 设置角色描述
     *
     * @param roleDesc 角色描述
     */
    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    /**
     * 获取排序列
     *
     * @return SORT - 排序列
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序列
     *
     * @param sort 排序列
     */
    public void setSort(Integer sort) {
        this.sort = sort;
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

    /**
     * 获取是否默认角色
     *
     * @return IS_DEFAULT - 是否默认角色
     */
    public String getIsDefault() {
        return isDefault;
    }

    /**
     * 设置是否默认角色
     *
     * @param isDefault 是否默认角色
     */
    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }
}