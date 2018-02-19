package space.dyenigma.service;

import java.util.List;

import space.dyenigma.common.Pagination;
import space.dyenigma.common.PaginationResult;
import space.dyenigma.shiro.ShiroUser;
import space.dyenigma.util.ResponseJson;

/**
 * origin/space.dyenigma.service
 *
 * @Description:
 * @Author: dingdongliang
 * @Date: 2018/2/14 19:20
 */
public interface ShiroUserService extends EntityService<ShiroUser, Long> {

    ShiroUser findByUsername(String userName);

    List<ShiroUser> findList();

    PaginationResult<ShiroUser> findAllByPage(Pagination<ShiroUser> pagination);

    ResponseJson editUser(ShiroUser shiroUser);

    ResponseJson editUserRole(String username, String roles);

    ResponseJson del(String ids) throws Exception;

    /**
     * @param userNameStr
     * @param status
     * @return space.dyenigma.util.ResponseJson
     * @Description: 用户审核
     * @author dingdongliang
     * @date 2018/2/14 19:21
     */
    ResponseJson audit(String userNameStr, String status) throws Exception;

    ShiroUser findByUsernameForUpdate(String username);

    ResponseJson addUser(ShiroUser shiroUser);

    ResponseJson checkNameOrEmallExist(ShiroUser shiroUser);
}
