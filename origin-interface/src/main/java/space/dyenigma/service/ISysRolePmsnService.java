package space.dyenigma.service;

import space.dyenigma.entity.SysPermission;
import space.dyenigma.entity.SysRolePmsn;

import java.util.List;

/**
 * origin/space.dyenigma.service
 *
 * @Description:
 * @Author: dingdongliang
 * @Date: 2017/07/21
 */
public interface ISysRolePmsnService extends IBaseService<SysRolePmsn> {
    /**
     * @param roleId
     * @return java.util.List<space.dyenigma.entity.SysPermission>
     * @Description : 好代码自己会说话
     * @author dingdongliang
     * @date 2018/2/20 19:24
     */
    List<SysPermission> findAllByRoleId(String roleId);

    /**
     * @param roleId
     * @param checkedIds
     * @return boolean
     * @Description : 保存分配角色权限
     * @author dingdongliang
     * @date 2018/2/20 19:24
     */
    boolean savePermission(String roleId, String checkedIds);

    boolean setDefaultRole(String roleId);
}
