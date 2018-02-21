package space.dyenigma.service;

import space.dyenigma.entity.SysUser;
import space.dyenigma.model.TreeModel;
import space.dyenigma.util.PageUtil;

import java.util.List;
import java.util.Set;

/**
 * origin/space.dyenigma.service
 *
 * @Description:
 * @Author: dingdongliang
 * @Date: 2017/07/21
 */
public interface ISysUserService extends IBaseService<SysUser> {
    /**
     * @param name
     * @return space.dyenigma.entity.SysUser
     * @Description : 根据名字查询用户,用于shiro权限控制
     * @author dingdongliang
     * @date 2018/2/20 19:26
     */
    SysUser getUserByName(String name);

    /**
     * @param user
     * @return boolean
     * @Description : 持久化用户信息
     * @author dingdongliang
     * @date 2018/2/20 19:26
     */
    boolean persistenceUser(SysUser user);

    /**
     * @param pageUtil
     * @return java.util.List<space.dyenigma.entity.SysUser>
     * @Description : 分页查, String postId询用户信息
     * @author dingdongliang
     * @date 2018/2/20 19:26
     */
    List<SysUser> allUserByPage(PageUtil pageUtil);

    /**
     * @param pageUtil
     * @param idList
     * @return java.util.List<space.dyenigma.entity.SysUser>
     * @Description : 按用户ID集合查询用户信息，分页，用于获取岗位、部门、公司的所有用户信息
     * @author dingdongliang
     * @date 2018/2/20 19:26
     */
    List<SysUser> findUserByPage(PageUtil pageUtil, Set<String> idList);

    boolean delUser(String userId);

    /**
     * @param list
     * @return java.util.List<space.dyenigma.model.TreeModel>
     * @Description : 获取所有可添加用户的岗位，按树状结构展示
     * @author dingdongliang
     * @date 2018/2/20 19:26
     */
    List<TreeModel> getPostList(List<TreeModel> list);
}
