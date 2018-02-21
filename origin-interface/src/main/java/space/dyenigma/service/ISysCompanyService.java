package space.dyenigma.service;

import space.dyenigma.entity.SysCompany;
import space.dyenigma.util.PageUtil;

import space.dyenigma.model.TreeModel;

import java.util.List;

/**
 * origin/space.dyenigma.service
 *
 * @Description:
 * @Author: dingdongliang
 * @Date: 2017/07/21
 */
public interface ISysCompanyService extends IBaseService<SysCompany> {
    /**
     * @param
     * @return java.util.List<TreeModel>
     * @Description : 获取所有的公司名称和ID
     * @author dingdongliang
     * @date 2018/2/20 19:17
     */
    List<TreeModel> getAllCoName();

    /**
     * Description: 查找所有的公司信息
     * Name:findComp
     * Author:dyenigma
     * Time:2016/4/22 11:59
     * param:[pageUtil]
     * return:java.util.List<space.dyenigma.entity.SysCompany>
     */
    List<SysCompany> findComp(PageUtil pageUtil);

    /**
     * Description: 根据ID删除公司信息
     * Name:delComp
     * Author:dyenigma
     * Time:2016/4/22 11:59
     * param:[compId]
     * return:boolean
     */
    boolean delComp(String compId);

    /**
     * Description: 持久化公司信息，根据ID判断是insert还是update
     * Name:persistenceComp
     * Author:dyenigma
     * Time:2016/4/22 11:59
     * param:[SysCompany]
     * return:boolean
     */
    boolean persistenceComp(SysCompany company);

    /**
     * Description: 查询某个公司下所有的公司信息，包含下属多级公司
     * Name:AllCoById
     * Author:dyenigma
     * Time:2016/4/28 11:10
     * param:[coId]
     * return:java.util.List<space.dyenigma.entity.SysCompany>
     */
    List<SysCompany> AllCoById(String coId);

    List<SysCompany> findByPid(String pid);
}
