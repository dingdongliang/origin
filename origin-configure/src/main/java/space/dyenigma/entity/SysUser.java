package space.dyenigma.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "sys_user")
public class SysUser extends BaseDomain {
    /**
     * 用户自增ID
     */
    @Id
    @Column(name = "USER_ID")
    private String userId;

    /**
     * 用户名称
     */
    @Column(name = "USER_NAME")
    private String userName;

    /**
     * 用户账号
     */
    @Column(name = "ACCOUNT")
    private String account;

    /**
     * 密码
     */
    @Column(name = "PASSWORD")
    private String password;

    /**
     * 电子邮箱
     */
    @Column(name = "USER_EMAIL")
    private String userEmail;

    /**
     * 用户电话
     */
    @Column(name = "USER_PHONE")
    private String userPhone;

    /**
     * 第一次登录
     */
    @Column(name = "FIRST_LOGIN")
    private Date firstLogin;

    /**
     * 上一次登录
     */
    @Column(name = "PREV_LOGIN")
    private Date prevLogin;

    /**
     * 上一次登录IP地址
     */
    @Column(name = "PREV_IP")
    private String prevIp;

    /**
     * 最后一次登录
     */
    @Column(name = "LAST_LOGIN")
    private Date lastLogin;

    /**
     * 登录次数
     */
    @Column(name = "LOGIN_COUNT")
    private String loginCount;

    /**
     * 当前状态,E:有效的,I:无效的
     */
    @Column(name = "STATUS")
    private String status;

    /**
     * 备注
     */
    @Column(name = "USER_DESC")
    private String userDesc;

    /**
     * 是否在线，1在线0不在线
     */
    @Column(name = "IS_ONLINE")
    private Integer isOnline;

    /**
     * 排序列
     */
    @Column(name = "SORT")
    private Integer sort;

    /**
     * 获取用户自增ID
     *
     * @return USER_ID - 用户自增ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户自增ID
     *
     * @param userId 用户自增ID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取用户名称
     *
     * @return USER_NAME - 用户名称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名称
     *
     * @param userName 用户名称
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取用户账号
     *
     * @return ACCOUNT - 用户账号
     */
    public String getAccount() {
        return account;
    }

    /**
     * 设置用户账号
     *
     * @param account 用户账号
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * 获取密码
     *
     * @return PASSWORD - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取电子邮箱
     *
     * @return USER_EMAIL - 电子邮箱
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * 设置电子邮箱
     *
     * @param userEmail 电子邮箱
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * 获取用户电话
     *
     * @return USER_PHONE - 用户电话
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * 设置用户电话
     *
     * @param userPhone 用户电话
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    /**
     * 获取第一次登录
     *
     * @return FIRST_LOGIN - 第一次登录
     */
    public Date getFirstLogin() {
        return firstLogin;
    }

    /**
     * 设置第一次登录
     *
     * @param firstLogin 第一次登录
     */
    public void setFirstLogin(Date firstLogin) {
        this.firstLogin = firstLogin;
    }

    /**
     * 获取上一次登录
     *
     * @return PREV_LOGIN - 上一次登录
     */
    public Date getPrevLogin() {
        return prevLogin;
    }

    /**
     * 设置上一次登录
     *
     * @param prevLogin 上一次登录
     */
    public void setPrevLogin(Date prevLogin) {
        this.prevLogin = prevLogin;
    }

    /**
     * 获取上一次登录IP地址
     *
     * @return PREV_IP - 上一次登录IP地址
     */
    public String getPrevIp() {
        return prevIp;
    }

    /**
     * 设置上一次登录IP地址
     *
     * @param prevIp 上一次登录IP地址
     */
    public void setPrevIp(String prevIp) {
        this.prevIp = prevIp;
    }

    /**
     * 获取最后一次登录
     *
     * @return LAST_LOGIN - 最后一次登录
     */
    public Date getLastLogin() {
        return lastLogin;
    }

    /**
     * 设置最后一次登录
     *
     * @param lastLogin 最后一次登录
     */
    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    /**
     * 获取登录次数
     *
     * @return LOGIN_COUNT - 登录次数
     */
    public String getLoginCount() {
        return loginCount;
    }

    /**
     * 设置登录次数
     *
     * @param loginCount 登录次数
     */
    public void setLoginCount(String loginCount) {
        this.loginCount = loginCount;
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
     * 获取备注
     *
     * @return USER_DESC - 备注
     */
    public String getUserDesc() {
        return userDesc;
    }

    /**
     * 设置备注
     *
     * @param userDesc 备注
     */
    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc;
    }

    /**
     * 获取是否在线，1在线0不在线
     *
     * @return IS_ONLINE - 是否在线，1在线0不在线
     */
    public Integer getIsOnline() {
        return isOnline;
    }

    /**
     * 设置是否在线，1在线0不在线
     *
     * @param isOnline 是否在线，1在线0不在线
     */
    public void setIsOnline(Integer isOnline) {
        this.isOnline = isOnline;
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

}