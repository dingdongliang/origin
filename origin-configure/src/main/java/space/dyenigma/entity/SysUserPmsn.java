package space.dyenigma.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "sys_user_pmsn")
public class SysUserPmsn extends BaseDomain {
    /**
     * 用户权限配置自增ID
     */
    @Id
    @Column(name = "UPM_ID")
    private String upmId;

    /**
     * 用户ID
     */
    @Column(name = "USER_ID")
    private String userId;

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
     * 获取用户权限配置自增ID
     *
     * @return UPM_ID - 用户权限配置自增ID
     */
    public String getUpmId() {
        return upmId;
    }

    /**
     * 设置用户权限配置自增ID
     *
     * @param upmId 用户权限配置自增ID
     */
    public void setUpmId(String upmId) {
        this.upmId = upmId;
    }

    /**
     * 获取用户ID
     *
     * @return USER_ID - 用户ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(String userId) {
        this.userId = userId;
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