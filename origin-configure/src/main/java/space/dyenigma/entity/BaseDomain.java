package space.dyenigma.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;

import java.util.Date;

/**
 * origin/space.dyenigma.entity
 *
 * @Description: 实体类基类，重写toString()方法，其他公共方法
 * @Author: dingdongliang
 * @Date: 2017/7/21 10:36
 */
public class BaseDomain {
    /**
     * 创造日期
     */
    @Column(name = "CREATED")
    protected Date created;
    /**
     * 修改日期
     */
    @Column(name = "LASTMOD")
    protected Date lastmod;
    /**
     * 创建人
     */
    @Column(name = "CREATER")
    protected String creater;
    /**
     * 修改人
     */
    @Column(name = "MODIFYER")
    protected String modifyer;

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getLastmod() {
        return lastmod;
    }

    public void setLastmod(Date lastmod) {
        this.lastmod = lastmod;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getModifyer() {
        return modifyer;
    }

    public void setModifyer(String modifyer) {
        this.modifyer = modifyer;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * @param domain
     * @param userId
     * @return space.dyenigma.entity.BaseDomain
     * @Description : 数据库记录字段赋值，新添加记录时调用
     * @author dingdongliang
     * @date 2018/2/20 19:04
     */
    public static BaseDomain createLog(BaseDomain domain, String userId) {
        return createLog(domain, userId, true);
    }

    /**
     * @param domain
     * @param userId
     * @return space.dyenigma.entity.BaseDomain
     * @Description : 数据库记录字段赋值，修改记录时调用
     * @author dingdongliang
     * @date 2018/2/20 19:04
     */
    public static BaseDomain editLog(BaseDomain domain, String userId) {
        return createLog(domain, userId, false);
    }

    /**
     * @param domain
     * @param userId
     * @param flag   当为true时，为新数据，false为修改数据
     * @return space.dyenigma.entity.BaseDomain
     * @Description : 数据库记录字段赋值，统一处理方法
     * @author dingdongliang
     * @date 2018/2/20 19:04
     */
    public static BaseDomain createLog(BaseDomain domain, String userId, boolean flag) {
        if (flag) {
            domain.setCreated(new Date());
            domain.setLastmod(new Date());
            domain.setCreater(userId);
            domain.setModifyer(userId);
        } else {
            domain.setLastmod(new Date());
            domain.setModifyer(userId);
        }
        return domain;
    }
}