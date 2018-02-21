package space.dyenigma.dao;

import space.dyenigma.core.Mapper;
import space.dyenigma.entity.SysRolePmsn;

import java.util.List;

public interface SysRolePmsnMapper extends Mapper<SysRolePmsn> {
    /**
     * @param roleId
     * @return java.util.List<space.dyenigma.entity.SysRolePmsn>
     * @Description : 根据角色ID查询所有的映射信息，用于角色管理菜单中勾选treeGrid
     * @author dingdongliang
     * @date 2018/2/20 19:10
     */
    List<SysRolePmsn> findAllByRoleId(String roleId);

    /**
     * @param
     * @return java.util.List<java.lang.String>
     * @Description : 查找所有的有映射记录的角色信息，用于自动分配新增加的默认权限菜单
     * @author dingdongliang
     * @date 2018/2/20 19:10
     */
    List<String> findAllRoleId();

    /**
     * @param permissionId
     * @return java.util.List<java.lang.String>
     * @Description : 查找所有的映射菜单记录，用于判断某个菜单是否能删除
     * @author dingdongliang
     * @date 2018/2/20 19:10
     */
    List<String> findAllByPmsnId(String permissionId);

    int delByPmsnId(String pmsnId);
}