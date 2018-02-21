package space.dyenigma.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "sys_permission")
public class SysPermission extends BaseDomain {
    /**
     * 权限自增ID
     */
    @Id
    @Column(name = "PMSN_ID")
    private String pmsnId;

    /**
     * 权限名称
     */
    @Column(name = "PMSN_NAME")
    private String pmsnName;

    /**
     * 父权限ID
     */
    @Column(name = "PRNT_ID")
    private String prntId;

    /**
     * 父权限名称
     */
    @Column(name = "PRNT_NAME")
    private String prntName;

    /**
     * 权限标识
     */
    @Column(name = "PMSN_CODE")
    private String pmsnCode;

    /**
     * 排序列
     */
    @Column(name = "SORT")
    private Integer sort;

    /**
     * 权限类型,M:菜单,O:操作
     */
    @Column(name = "PMSN_TYPE")
    private String pmsnType;

    /**
     * 当前状态,E:有效的,I:无效的
     */
    @Column(name = "STATUS")
    private String status;

    /**
     * 权限对应URL
     */
    @Column(name = "PMSN_URL")
    private String pmsnUrl;

    /**
     * 图标
     */
    @Column(name = "ICON_CLS")
    private String iconCls;

    /**
     * 权限描述
     */
    @Column(name = "PMSN_DESC")
    private String pmsnDesc;

    /**
     * 标记能否打开，相当于叶节点判断，open不能打开closed可以打开
     */
    @Column(name = "STATE")
    private String state;

    /**
     * 是否默认权限，Y是N否
     */
    @Column(name = "IS_DEFAULT")
    private String isDefault;

    /**
     * 是否启动，Y是N否
     */
    @Column(name = "IS_USED")
    private String isUsed;

    /**
     * 获取权限自增ID
     *
     * @return PMSN_ID - 权限自增ID
     */
    public String getPmsnId() {
        return pmsnId;
    }

    /**
     * 设置权限自增ID
     *
     * @param pmsnId 权限自增ID
     */
    public void setPmsnId(String pmsnId) {
        this.pmsnId = pmsnId;
    }

    /**
     * 获取权限名称
     *
     * @return PMSN_NAME - 权限名称
     */
    public String getPmsnName() {
        return pmsnName;
    }

    /**
     * 设置权限名称
     *
     * @param pmsnName 权限名称
     */
    public void setPmsnName(String pmsnName) {
        this.pmsnName = pmsnName;
    }

    /**
     * 获取父权限ID
     *
     * @return PRNT_ID - 父权限ID
     */
    public String getPrntId() {
        return prntId;
    }

    /**
     * 设置父权限ID
     *
     * @param prntId 父权限ID
     */
    public void setPrntId(String prntId) {
        this.prntId = prntId;
    }

    /**
     * 获取父权限名称
     *
     * @return PRNT_NAME - 父权限名称
     */
    public String getPrntName() {
        return prntName;
    }

    /**
     * 设置父权限名称
     *
     * @param prntName 父权限名称
     */
    public void setPrntName(String prntName) {
        this.prntName = prntName;
    }

    /**
     * 获取权限标识
     *
     * @return PMSN_CODE - 权限标识
     */
    public String getPmsnCode() {
        return pmsnCode;
    }

    /**
     * 设置权限标识
     *
     * @param pmsnCode 权限标识
     */
    public void setPmsnCode(String pmsnCode) {
        this.pmsnCode = pmsnCode;
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
     * 获取权限类型,M:菜单,O:操作
     *
     * @return PMSN_TYPE - 权限类型,M:菜单,O:操作
     */
    public String getPmsnType() {
        return pmsnType;
    }

    /**
     * 设置权限类型,M:菜单,O:操作
     *
     * @param pmsnType 权限类型,M:菜单,O:操作
     */
    public void setPmsnType(String pmsnType) {
        this.pmsnType = pmsnType;
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
     * 获取权限对应URL
     *
     * @return PMSN_URL - 权限对应URL
     */
    public String getPmsnUrl() {
        return pmsnUrl;
    }

    /**
     * 设置权限对应URL
     *
     * @param pmsnUrl 权限对应URL
     */
    public void setPmsnUrl(String pmsnUrl) {
        this.pmsnUrl = pmsnUrl;
    }

    /**
     * 获取图标
     *
     * @return ICON_CLS - 图标
     */
    public String getIconCls() {
        return iconCls;
    }

    /**
     * 设置图标
     *
     * @param iconCls 图标
     */
    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    /**
     * 获取权限描述
     *
     * @return PMSN_DESC - 权限描述
     */
    public String getPmsnDesc() {
        return pmsnDesc;
    }

    /**
     * 设置权限描述
     *
     * @param pmsnDesc 权限描述
     */
    public void setPmsnDesc(String pmsnDesc) {
        this.pmsnDesc = pmsnDesc;
    }

    /**
     * 获取标记能否打开，相当于叶节点判断，open不能打开closed可以打开
     *
     * @return STATE - 标记能否打开，相当于叶节点判断，open不能打开closed可以打开
     */
    public String getState() {
        return state;
    }

    /**
     * 设置标记能否打开，相当于叶节点判断，open不能打开closed可以打开
     *
     * @param state 标记能否打开，相当于叶节点判断，open不能打开closed可以打开
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 获取是否默认权限，Y是N否
     *
     * @return IS_DEFAULT - 是否默认权限，Y是N否
     */
    public String getIsDefault() {
        return isDefault;
    }

    /**
     * 设置是否默认权限，Y是N否
     *
     * @param isDefault 是否默认权限，Y是N否
     */
    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    /**
     * 获取是否启动，Y是N否
     *
     * @return IS_USED - 是否启动，Y是N否
     */
    public String getIsUsed() {
        return isUsed;
    }

    /**
     * 设置是否启动，Y是N否
     *
     * @param isUsed 是否启动，Y是N否
     */
    public void setIsUsed(String isUsed) {
        this.isUsed = isUsed;
    }
}