package space.dyenigma.service;

import java.util.List;

import space.dyenigma.common.Pagination;
import space.dyenigma.common.PaginationResult;
import space.dyenigma.shiro.ShiroRole;

/**
 * origin/space.dyenigma.service
 *
 * @Description:
 * @Author: dingdongliang
 * @Date: 2018/2/14 19:20
 */
public interface ShiroRoleService extends EntityService<ShiroRole, Long> {

    ShiroRole findByRoleName(String rolename);

    ShiroRole findById(Integer id);

    List<ShiroRole> findRoleList();

    PaginationResult<ShiroRole> findAllByPage(Pagination<ShiroRole> pagination);

}
