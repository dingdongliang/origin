package space.dyenigma.service;

import space.dyenigma.entity.SysDivision;
import space.dyenigma.model.TreeModel;

import java.util.List;

/**
 * origin/space.dyenigma.service
 *
 * @Description:
 * @Author: dingdongliang
 * @Date: 2018/2/14 20:41
 */
public interface ISysDivisionService extends IBaseService<SysDivision> {
    /**
     * @param id
     * @return boolean
     * @Description : 删除某个节点组织(更新状态为I)
     * @author dingdongliang
     * @date 2018/2/20 19:21
     */
    boolean deleteById(String id);

    /**
     * @param id
     * @return java.util.List<space.dyenigma.model.TreeModel>
     * @Description : 获取所有可添加子项的组织
     * @author dingdongliang
     * @date 2018/2/20 19:21
     */
    List<TreeModel> findSuperOrgan(String id);

    /**
     * @param organ
     * @return boolean
     * @Description : 持久化处理组织
     * @author dingdongliang
     * @date 2018/2/20 19:21
     */
    boolean persistenceOrgan(SysDivision organ);

    /**
     * @param id
     * @return java.util.List<space.dyenigma.entity.SysDivision>
     * @Description : 根据公司ID查询部门信息
     * @author dingdongliang
     * @date 2018/2/20 19:21
     */
    List<SysDivision> findDivByCoId(String id);
}
