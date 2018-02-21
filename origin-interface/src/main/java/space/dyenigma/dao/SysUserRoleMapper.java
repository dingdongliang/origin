package space.dyenigma.dao;

import space.dyenigma.core.Mapper;
import space.dyenigma.entity.SysUserRole;

import java.util.List;

public interface SysUserRoleMapper extends Mapper<SysUserRole> {
    /**
     * @param userId
     * @return java.util.List<space.dyenigma.entity.SysUserRole>
     * @Description : 获取某个用户的所有角色信息
     * @author dingdongliang
     * @date 2018/2/20 19:11
     */
    List<SysUserRole> findAllByUserId(String userId);

    List<SysUserRole> findAllByRoleId(String roleId);
}