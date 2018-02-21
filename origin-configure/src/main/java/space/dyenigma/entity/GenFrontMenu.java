package space.dyenigma.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "gen_front_menu")
public class GenFrontMenu extends BaseDomain {
    /**
     * 菜单ID
     */
    @Id
    @Column(name = "FM_ID")
    private String fmId;

    /**
     * 菜单链接
     */
    @Column(name = "FM_URL")
    private String fmUrl;

    /**
     * 菜单描述
     */
    @Column(name = "FM_DESC")
    private String fmDesc;

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
     * 获取菜单ID
     *
     * @return FM_ID - 菜单ID
     */
    public String getFmId() {
        return fmId;
    }

    /**
     * 设置菜单ID
     *
     * @param fmId 菜单ID
     */
    public void setFmId(String fmId) {
        this.fmId = fmId;
    }

    /**
     * 获取菜单链接
     *
     * @return FM_URL - 菜单链接
     */
    public String getFmUrl() {
        return fmUrl;
    }

    /**
     * 设置菜单链接
     *
     * @param fmUrl 菜单链接
     */
    public void setFmUrl(String fmUrl) {
        this.fmUrl = fmUrl;
    }

    /**
     * 获取菜单描述
     *
     * @return FM_DESC - 菜单描述
     */
    public String getFmDesc() {
        return fmDesc;
    }

    /**
     * 设置菜单描述
     *
     * @param fmDesc 菜单描述
     */
    public void setFmDesc(String fmDesc) {
        this.fmDesc = fmDesc;
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

}