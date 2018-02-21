package space.dyenigma.service;

import space.dyenigma.entity.SysUserPmsn;

import java.util.List;

/**
 * origin/space.dyenigma.service
 *
 * @Description:
 * @Author: dingdongliang
 * @Date: 2017/07/21
 */
public interface ISysUserPmsnService extends IBaseService<SysUserPmsn> {

    /**
     * @param userId     用户id
     * @param checkedIds 岗位ID集合
     * @return boolean
     * @Description : 保存分配用户权限
     * @author dingdongliang
     * @date 2018/2/20 19:24
     */
    boolean saveUserPmsn(String userId, String checkedIds);

    /**
     * @param userId
     * @return java.util.List<space.dyenigma.entity.SysUserPmsn>
     * @Description : 获取用户的所有直接权限映射信息
     * @author dingdongliang
     * @date 2018/2/20 19:25
     */
    List<SysUserPmsn> findByUserId(String userId);
}
