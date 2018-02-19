package space.dyenigma.shiro;

import java.util.List;

import space.dyenigma.common.Pagination;
import space.dyenigma.common.PaginationResult;
import space.dyenigma.service.EntityService;

/**
 * origin/space.dyenigma.shiro
 *
 * @Description:
 * @Author: dingdongliang
 * @Date: 2018/2/14 19:15
 */
public interface FunctionService extends EntityService<Function, Long> {

    PaginationResult<Function> findAllByPage(Pagination<Function> pagination);

    List<Function> findList();

    Function findById(Integer id);

    Function findByPermissionName(String permissionName);

    Function findByPid(Integer pid);

    List<Function> findListByPid(Integer pid);
}