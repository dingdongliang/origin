package space.dyenigma.service;

import space.dyenigma.entity.SysPostRole;

import java.util.List;

/**
 * Description:
 * author  dyenigma
 * date 2017/07/21
 */
public interface ISysPostRoleService extends IBaseService<SysPostRole> {
    /**
     * 保存分配岗位角色
     * param postId 岗位id
     * param checkedIds 角色ID集合
     * return
     */
    boolean savePostRole(String postId, String checkedIds);

    List<SysPostRole> getPostRoleByPostId(String postId);
}
