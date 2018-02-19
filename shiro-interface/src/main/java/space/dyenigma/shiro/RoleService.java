package space.dyenigma.shiro;

import space.dyenigma.common.Pagination;
import space.dyenigma.common.PaginationResult;
import space.dyenigma.service.EntityService;

/**
 * origin/space.dyenigma.shiro
 *
 * @Description:
 * @Author: dingdongliang
 * @Date: 2018/2/14 19:16
 */
public interface RoleService extends EntityService<ShiroRole, Long> {

    PaginationResult<ShiroRole> findAllByPage(Pagination<ShiroRole> pagination);
}
