package space.dyenigma.service;

import space.dyenigma.entity.SysRole;
import space.dyenigma.entity.SysUserRole;

import java.util.List;

/**
 * origin/space.dyenigma.service
 *
 * @Description:
 * @Author: dingdongliang
 * @Date: 2017/07/21
 */
public interface ISysUserRoleService extends IBaseService<SysUserRole> {
    /**
     * @param userId
     * @return java.util.List<space.dyenigma.entity.SysRole>
     * @Description : 好代码自己会说话
     * @author dingdongliang
     * @date 2018/2/20 19:25
     */
    List<SysRole> findAllByUserId(String userId);

    /**
     * @param userId
     * @return java.util.List<space.dyenigma.entity.SysUserRole>
     * @Description : 根据用户ID获取所有用户角色映射关系
     * @author dingdongliang
     * @date 2018/2/20 19:26
     */
    List<SysUserRole> findByUserId(String userId);

    /**
     * @param userId     角色id
     * @param checkedIds 菜单权限ID集合
     * @return boolean
     * @Description : 保存分配角色权限
     * @author dingdongliang
     * @date 2018/2/20 19:26
     */
    boolean saveRole(String userId, String checkedIds);
}
