package space.dyenigma.entity;

import space.dyenigma.util.ExcelVOAttribute;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "sys_company")
public class SysCompany extends BaseDomain {
    /**
     * 公司自增ID
     */
    @Id
    @Column(name = "CO_ID")
    private String coId;

    /**
     * 公司名称
     */
    @Column(name = "CO_NAME")
    @ExcelVOAttribute(name = "公司名称", column = "A", isExport = true, prompt = "这是公司名称!")
    private String coName;

    /**
     * 父公司ID
     */
    @Column(name = "PRNT_ID")
    private String prntId;

    /**
     * 父公司名称
     */
    @Column(name = "PRNT_NAME")
    @ExcelVOAttribute(name = "父公司名称", column = "I")
    private String prntName;

    /**
     * 是否有下级公司
     */
    @Column(name = "STATE")
    private String state;

    /**
     * 公司标记
     */
    @Column(name = "ICON_CLS")
    private String iconCls;

    /**
     * 公司电话
     */
    @Column(name = "CO_PHONE")
    @ExcelVOAttribute(name = "公司电话", column = "B")
    private String coPhone;

    /**
     * 公司传真
     */
    @Column(name = "CO_FAX")
    @ExcelVOAttribute(name = "公司传真", column = "C")
    private String coFax;

    /**
     * 公司地址
     */
    @Column(name = "CO_ADR")
    @ExcelVOAttribute(name = "公司地址", column = "D")
    private String coAdr;

    /**
     * 邮政编码
     */
    @Column(name = "CO_ZIP")
    @ExcelVOAttribute(name = "邮政编码", column = "E")
    private String coZip;

    /**
     * 排序列
     */
    @Column(name = "SORT")
    private Integer sort;

    /**
     * 公司邮件地址
     */
    @Column(name = "CO_EMAIL")
    @ExcelVOAttribute(name = "Email", column = "F")
    private String coEmail;

    /**
     * 公司联络人
     */
    @Column(name = "CONTACT")
    @ExcelVOAttribute(name = "联系人", column = "G")
    private String contact;

    /**
     * 当前状态,E:有效的,I:无效的
     */
    @Column(name = "STATUS")
    private String status;

    /**
     * 公司负责人
     */
    @Column(name = "MANAGER")
    private String manager;

    /**
     * 开户行
     */
    @Column(name = "BANK")
    private String bank;

    /**
     * 银行账号
     */
    @Column(name = "BANK_ACCT")
    private String bankAcct;

    /**
     * 备注
     */
    @Column(name = "CO_DESC")
    @ExcelVOAttribute(name = "描述", column = "H")
    private String coDesc;

    /**
     * 获取公司自增ID
     *
     * @return CO_ID - 公司自增ID
     */
    public String getCoId() {
        return coId;
    }

    /**
     * 设置公司自增ID
     *
     * @param coId 公司自增ID
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
     * 获取父公司ID
     *
     * @return PRNT_ID - 父公司ID
     */
    public String getPrntId() {
        return prntId;
    }

    /**
     * 设置父公司ID
     *
     * @param prntId 父公司ID
     */
    public void setPrntId(String prntId) {
        this.prntId = prntId;
    }

    /**
     * 获取父公司名称
     *
     * @return PRNT_NAME - 父公司名称
     */
    public String getPrntName() {
        return prntName;
    }

    /**
     * 设置父公司名称
     *
     * @param prntName 父公司名称
     */
    public void setPrntName(String prntName) {
        this.prntName = prntName;
    }

    /**
     * 获取是否有下级公司
     *
     * @return STATE - 是否有下级公司
     */
    public String getState() {
        return state;
    }

    /**
     * 设置是否有下级公司
     *
     * @param state 是否有下级公司
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 获取公司标记
     *
     * @return ICON_CLS - 公司标记
     */
    public String getIconCls() {
        return iconCls;
    }

    /**
     * 设置公司标记
     *
     * @param iconCls 公司标记
     */
    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    /**
     * 获取公司电话
     *
     * @return CO_PHONE - 公司电话
     */
    public String getCoPhone() {
        return coPhone;
    }

    /**
     * 设置公司电话
     *
     * @param coPhone 公司电话
     */
    public void setCoPhone(String coPhone) {
        this.coPhone = coPhone;
    }

    /**
     * 获取公司传真
     *
     * @return CO_FAX - 公司传真
     */
    public String getCoFax() {
        return coFax;
    }

    /**
     * 设置公司传真
     *
     * @param coFax 公司传真
     */
    public void setCoFax(String coFax) {
        this.coFax = coFax;
    }

    /**
     * 获取公司地址
     *
     * @return CO_ADR - 公司地址
     */
    public String getCoAdr() {
        return coAdr;
    }

    /**
     * 设置公司地址
     *
     * @param coAdr 公司地址
     */
    public void setCoAdr(String coAdr) {
        this.coAdr = coAdr;
    }

    /**
     * 获取邮政编码
     *
     * @return CO_ZIP - 邮政编码
     */
    public String getCoZip() {
        return coZip;
    }

    /**
     * 设置邮政编码
     *
     * @param coZip 邮政编码
     */
    public void setCoZip(String coZip) {
        this.coZip = coZip;
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
     * 获取公司邮件地址
     *
     * @return CO_EMAIL - 公司邮件地址
     */
    public String getCoEmail() {
        return coEmail;
    }

    /**
     * 设置公司邮件地址
     *
     * @param coEmail 公司邮件地址
     */
    public void setCoEmail(String coEmail) {
        this.coEmail = coEmail;
    }

    /**
     * 获取公司联络人
     *
     * @return CONTACT - 公司联络人
     */
    public String getContact() {
        return contact;
    }

    /**
     * 设置公司联络人
     *
     * @param contact 公司联络人
     */
    public void setContact(String contact) {
        this.contact = contact;
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
     * 获取公司负责人
     *
     * @return MANAGER - 公司负责人
     */
    public String getManager() {
        return manager;
    }

    /**
     * 设置公司负责人
     *
     * @param manager 公司负责人
     */
    public void setManager(String manager) {
        this.manager = manager;
    }

    /**
     * 获取开户行
     *
     * @return BANK - 开户行
     */
    public String getBank() {
        return bank;
    }

    /**
     * 设置开户行
     *
     * @param bank 开户行
     */
    public void setBank(String bank) {
        this.bank = bank;
    }

    /**
     * 获取银行账号
     *
     * @return BANK_ACCT - 银行账号
     */
    public String getBankAcct() {
        return bankAcct;
    }

    /**
     * 设置银行账号
     *
     * @param bankAcct 银行账号
     */
    public void setBankAcct(String bankAcct) {
        this.bankAcct = bankAcct;
    }

    /**
     * 获取备注
     *
     * @return CO_DESC - 备注
     */
    public String getCoDesc() {
        return coDesc;
    }

    /**
     * 设置备注
     *
     * @param coDesc 备注
     */
    public void setCoDesc(String coDesc) {
        this.coDesc = coDesc;
    }

}