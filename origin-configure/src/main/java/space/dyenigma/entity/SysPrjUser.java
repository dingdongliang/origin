package space.dyenigma.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "sys_prj_user")
public class SysPrjUser extends BaseDomain {
    /**
     * 项目成员配置自增ID
     */
    @Id
    @Column(name = "PU_ID")
    private String puId;

    /**
     * 项目组ID
     */
    @Column(name = "PRJ_ID")
    private String prjId;

    /**
     * 用户ID
     */
    @Column(name = "USER_ID")
    private String userId;

    /**
     * 当前状态,E:有效的,I:无效的
     */
    @Column(name = "STATUS")
    private String status;

    /**
     * 获取项目成员配置自增ID
     *
     * @return PU_ID - 项目成员配置自增ID
     */
    public String getPuId() {
        return puId;
    }

    /**
     * 设置项目成员配置自增ID
     *
     * @param puId 项目成员配置自增ID
     */
    public void setPuId(String puId) {
        this.puId = puId;
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