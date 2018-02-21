package space.dyenigma.dao;

import space.dyenigma.core.Mapper;
import space.dyenigma.entity.SysPermission;

import java.util.List;

public interface SysPermissionMapper extends Mapper<SysPermission> {
    /**
     * @param type
     * @return java.util.List<space.dyenigma.entity.SysPermission>
     * @Description : 超级管理员权限查询，type标志查询是菜单项(M)还是操作项(O)
     * @author dingdongliang
     * @date 2018/2/20 19:09
     */
    List<SysPermission> adminMenu(String type);

    /**
     * @param userId
     * @param type
     * @return java.util.List<space.dyenigma.entity.SysPermission>
     * @Description : 普通用户权限查询，type标志查询是菜单项(M)还是操作项(O)
     * @author dingdongliang
     * @date 2018/2/20 19:09
     */
    List<SysPermission> usersMenu(String userId, String type);

    /**
     * @param pid
     * @return java.util.List<space.dyenigma.entity.SysPermission>
     * @Description : 查询某个父菜单的子项
     * @author dingdongliang
     * @date 2018/2/20 19:09
     */
    List<SysPermission> findByPid(String pid);

    /**
     * @param
     * @return java.util.List<space.dyenigma.entity.SysPermission>
     * @Description : 获取所有可添加子项的权限信息
     * @author dingdongliang
     * @date 2018/2/20 19:09
     */
    List<SysPermission> findSuperFunc();

    /**
     * @param
     * @return java.util.List<space.dyenigma.entity.SysPermission>
     * @Description : 获取所有的权限，用于角色权限分配
     * @author dingdongliang
     * @date 2018/2/20 19:10
     */
    List<SysPermission> findAllMenu();

    /**
     * @param
     * @return java.util.List<space.dyenigma.entity.SysPermission>
     * @Description : 获取所有的默认有效权限，用于默认权限分配
     * @author dingdongliang
     * @date 2018/2/20 19:10
     */
    List<SysPermission> findAllDefault();

    /**
     * @param
     * @return java.util.List<space.dyenigma.entity.SysPermission>
     * @Description : 查找所有一级根目录
     * @author dingdongliang
     * @date 2018/2/20 19:10
     */
    List<SysPermission> findRootMenu();
}