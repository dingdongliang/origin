package space.dyenigma.dao;

import space.dyenigma.core.Mapper;
import space.dyenigma.entity.SysUser;
import space.dyenigma.util.PageUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface SysUserMapper extends Mapper<SysUser> {

    /**
     * @param name
     * @return space.dyenigma.entity.SysUser
     * @Description : 好名字自己会解释
     * @author dingdongliang
     * @date 2018/2/20 19:11
     */
    SysUser findByName(String name);

    /**
     * @param pageUtil
     * @return java.util.List<space.dyenigma.entity.SysUser>
     * @Description : 好名字自己会解释
     * @author dingdongliang
     * @date 2018/2/20 19:11
     */
    List<SysUser> findAllByPage(PageUtil pageUtil);

    /**
     * @param pageUtil
     * @param idSet
     * @return java.util.List<space.dyenigma.entity.SysUser>
     * @Description : 按用户ID集合查询用户信息，分页，用于获取岗位、部门、公司的所有用户信息
     * @author dingdongliang
     * @date 2018/2/20 19:11
     */
    List<SysUser> findUserByPage(@Param("pageUtil") PageUtil pageUtil, @Param("idSet") Set<String> idSet);

    /**
     * @param idSet
     * @return java.util.List<space.dyenigma.entity.SysUser>
     * @Description : 按用户ID集合查询用户信息，分页，用于获取岗位、部门、公司的所有用户信息
     * @author dingdongliang
     * @date 2018/2/20 19:11
     */
    List<SysUser> findUserByList(@Param("idSet") Set<String> idSet);
}