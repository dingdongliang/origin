package space.dyenigma.dao;

import space.dyenigma.core.Mapper;
import space.dyenigma.entity.SysRole;
import space.dyenigma.util.PageUtil;

import java.util.List;

public interface SysRoleMapper extends Mapper<SysRole> {
    /**
     * @param pageUtil
     * @return java.util.List<space.dyenigma.entity.SysRole>
     * @Description : 分页获取角色信息
     * @author dingdongliang
     * @date 2018/2/20 19:10
     */
    List<SysRole> findAllByPage(PageUtil pageUtil);

    List<SysRole> findDefaultRole();
}