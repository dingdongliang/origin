package space.dyenigma.service;

import space.dyenigma.entity.SysUserPost;

import java.util.List;

/**
 * origin/space.dyenigma.service
 *
 * @Description:
 * @Author: dingdongliang
 * @Date: 2017/07/21
 */
public interface ISysUserPostService extends IBaseService<SysUserPost> {
    /**
     * @param postId
     * @return java.util.List<java.lang.String>
     * @Description : 根据岗位查询用户ID集合
     * @author dingdongliang
     * @date 2018/2/20 19:25
     */
    List<String> findByPostId(String postId);

    /**
     * @param userId
     * @return java.util.List<space.dyenigma.entity.SysUserPost>
     * @Description : 根据用户ID查询所有的用户角色映射关系，用于预设
     * @author dingdongliang
     * @date 2018/2/20 19:25
     */
    List<SysUserPost> findByUserId(String userId);

    /**
     * @param userId
     * @param checkedIds 岗位ID集合
     * @return boolean
     * @Description : 保存分配用户岗位
     * @author dingdongliang
     * @date 2018/2/20 19:25
     */
    boolean saveUserPost(String userId, String checkedIds);
}
