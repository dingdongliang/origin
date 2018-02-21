package space.dyenigma.service;

import space.dyenigma.entity.SysRole;
import space.dyenigma.util.PageUtil;

import java.util.List;

/**
 * origin/space.dyenigma.service
 *
 * @Description:
 * @Author: dingdongliang
 * @Date: 2017/07/21
 */
public interface ISysRoleService extends IBaseService<SysRole> {
    /**
     * @param pageUtil
     * @return java.util.List<space.dyenigma.entity.SysRole>
     * @Description : 分页查询角色信息
     * @author dingdongliang
     * @date 2018/2/20 19:24
     */
    List<SysRole> findAllRoleList(PageUtil pageUtil);

    /**
     * @param role
     * @return boolean
     * @Description : 持久化角色信息（包含新增或修改）
     * @author dingdongliang
     * @date 2018/2/20 19:24
     */
    boolean persistenceRole(SysRole role);

    /**
     * @param id
     * @return boolean
     * @Description : 先判断是否有级联关系，再删除角色信息
     * @author dingdongliang
     * @date 2018/2/20 19:24
     */
    boolean delRole(String id);
}
