package space.dyenigma.service;

import space.dyenigma.entity.SysPermission;
import space.dyenigma.model.MenuModel;
import space.dyenigma.model.MultiMenu;
import space.dyenigma.model.TreeModel;

import java.util.List;

/**
 * origin/space.dyenigma.service
 *
 * @Description: 权限类业务处理
 * @Author: dingdongliang
 * @Date: 2017/07/21
 */
public interface ISysPermissionService extends IBaseService<SysPermission> {
    /**
     * @param
     * @return java.util.List<space.dyenigma.model.MenuModel>
     * @Description : 获取当前用户权限并拼接菜单信息
     * @author dingdongliang
     * @date 2018/2/20 19:21
     */
    List<MenuModel> createMenu();

    /**
     * @param type
     * @return java.util.List<space.dyenigma.entity.SysPermission>
     * @Description : 获取当前用户的权限, type标志查询是菜单项(F)还是操作项(O)
     * @author dingdongliang
     * @date 2018/2/20 19:21
     */
    List<SysPermission> getShiro(String type);

    /**
     * @param pid
     * @return java.util.List<space.dyenigma.entity.SysPermission>
     * @Description : 根据父类id获取子类菜单
     * @author dingdongliang
     * @date 2018/2/20 19:21
     */
    List<SysPermission> findByPid(String pid);

    /**
     * @param
     * @return java.util.List<space.dyenigma.model.MultiMenu>
     * @Description : 获取所有的权限，用于角色权限分配，尝试替代finaAllMenu方法
     * @author dingdongliang
     * @date 2018/2/20 19:21
     */
    List<MultiMenu> multiMenu();

    /**
     * @param id
     * @return boolean
     * @Description : 删除某个节点菜单(更新状态为I)
     * @author dingdongliang
     * @date 2018/2/20 19:22
     */
    boolean deleteById(String id);

    /**
     * @param
     * @return java.util.List<space.dyenigma.model.TreeModel>
     * @Description : 获取所有可添加子项的菜单
     * @author dingdongliang
     * @date 2018/2/20 19:22
     */
    List<TreeModel> findSuperFunc();

    /**
     * @param sysPermission
     * @return boolean
     * @Description : 持久化处理Permission
     * @author dingdongliang
     * @date 2018/2/20 19:22
     */
    boolean persistenceFunction(SysPermission sysPermission);
}
