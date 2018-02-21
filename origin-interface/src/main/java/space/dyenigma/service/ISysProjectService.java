package space.dyenigma.service;

import space.dyenigma.entity.SysProject;
import space.dyenigma.entity.SysUser;

import java.util.List;

/**
 * origin/space.dyenigma.service
 *
 * @Description:
 * @Author: dingdongliang
 * @Date: 2017/07/21
 */
public interface ISysProjectService extends IBaseService<SysProject> {
    /**
     * @param coId
     * @return java.util.List<space.dyenigma.entity.SysProject>
     * @Description : 查询公司所属项目组信息
     * @author dingdongliang
     * @date 2018/2/20 19:23
     */
    List<SysProject> getPrjByCoId(String coId);

    /**
     * @param prj
     * @return boolean
     * @Description : 实例化项目组信息
     * @author dingdongliang
     * @date 2018/2/20 19:23
     */
    boolean persistencePrj(SysProject prj);

    /**
     * @param prjId
     * @return boolean
     * @Description : 删除项目组
     * @author dingdongliang
     * @date 2018/2/20 19:23
     */
    boolean delPrj(String prjId);

    /**
     * @param prjId
     * @param checkedIds
     * @return boolean
     * @Description : 保存分配给项目组的角色
     * @author dingdongliang
     * @date 2018/2/20 19:23
     */
    boolean savePrjRole(String prjId, String checkedIds);

    /**
     * @param prjId
     * @param checkedIds
     * @return boolean
     * @Description : 保存分配给项目组的成员
     * @author dingdongliang
     * @date 2018/2/20 19:24
     */
    boolean savePrjUsers(String prjId, String checkedIds);

    /**
     * @param prjId
     * @return java.util.List<space.dyenigma.entity.SysUser>
     * @Description : 查找项目组成员
     * @author dingdongliang
     * @date 2018/2/20 19:24
     */
    List<SysUser> searchPrjUser(String prjId);
}
