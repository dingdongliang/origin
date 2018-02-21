package space.dyenigma.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "sys_division")
public class SysDivision extends BaseDomain {
    /**
     * 部门自增ID
     */
    @Id
    @Column(name = "DIV_ID")
    private String divId;

    /**
     * 部门名称
     */
    @Column(name = "DIV_NAME")
    private String divName;

    /**
     * 部门领导对应的USERID
     */
    @Column(name = "MANAGER")
    private String manager;

    /**
     * 部门电话
     */
    @Column(name = "DIV_PHONE")
    private String divPhone;

    /**
     * 部门地址
     */
    @Column(name = "DIV_ADR")
    private String divAdr;

    /**
     * 所属公司ID
     */
    @Column(name = "CO_ID")
    private String coId;

    /**
     * 公司名称
     */
    @Column(name = "CO_NAME")
    private String coName;

    /**
     * 备注
     */
    @Column(name = "DIV_DESC")
    private String divDesc;

    /**
     * 当前状态,E:有效的,I:无效的
     */
    @Column(name = "STATUS")
    private String status;

    /**
     * 图标
     */
    @Column(name = "ICON_CLS")
    private String iconCls;

    /**
     * 标记能否打开，相当于叶节点判断，open不能打开closed可以打开
     */
    @Column(name = "STATE")
    private String state;

    /**
     * 获取部门自增ID
     *
     * @return DIV_ID - 部门自增ID
     */
    public String getDivId() {
        return divId;
    }

    /**
     * 设置部门自增ID
     *
     * @param divId 部门自增ID
     */
    public void setDivId(String divId) {
        this.divId = divId;
    }

    /**
     * 获取部门名称
     *
     * @return DIV_NAME - 部门名称
     */
    public String getDivName() {
        return divName;
    }

    /**
     * 设置部门名称
     *
     * @param divName 部门名称
     */
    public void setDivName(String divName) {
        this.divName = divName;
    }

    /**
     * 获取部门领导对应的USERID
     *
     * @return MANAGER - 部门领导对应的USERID
     */
    public String getManager() {
        return manager;
    }

    /**
     * 设置部门领导对应的USERID
     *
     * @param manager 部门领导对应的USERID
     */
    public void setManager(String manager) {
        this.manager = manager;
    }

    /**
     * 获取部门电话
     *
     * @return DIV_PHONE - 部门电话
     */
    public String getDivPhone() {
        return divPhone;
    }

    /**
     * 设置部门电话
     *
     * @param divPhone 部门电话
     */
    public void setDivPhone(String divPhone) {
        this.divPhone = divPhone;
    }

    /**
     * 获取部门地址
     *
     * @return DIV_ADR - 部门地址
     */
    public String getDivAdr() {
        return divAdr;
    }

    /**
     * 设置部门地址
     *
     * @param divAdr 部门地址
     */
    public void setDivAdr(String divAdr) {
        this.divAdr = divAdr;
    }

    /**
     * 获取所属公司ID
     *
     * @return CO_ID - 所属公司ID
     */
    public String getCoId() {
        return coId;
    }

    /**
     * 设置所属公司ID
     *
     * @param coId 所属公司ID
     */
    public void setCoId(String coId) {
        this.coId = coId;
    }

    /**
     * 获取公司名称
     *
     * @return CO_NAME - 公司名称
     */
    public String getCoName() {
        return coName;
    }

    /**
     * 设置公司名称
     *
     * @param coName 公司名称
     */
    public void setCoName(String coName) {
        this.coName = coName;
    }

    /**
     * 获取备注
     *
     * @return DIV_DESC - 备注
     */
    public String getDivDesc() {
        return divDesc;
    }

    /**
     * 设置备注
     *
     * @param divDesc 备注
     */
    public void setDivDesc(String divDesc) {
        this.divDesc = divDesc;
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

}