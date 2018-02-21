package space.dyenigma.dao;

import space.dyenigma.core.Mapper;
import space.dyenigma.entity.SysPost;

import java.util.List;

public interface SysPostMapper extends Mapper<SysPost> {
    /**
     * @param divId
     * @return java.util.List<space.dyenigma.entity.SysPost>
     * @Description : 根据部门ID查询该部门下所有的岗位信息
     * @author dingdongliang
     * @date 2018/2/20 19:10
     */
    List<SysPost> findPostByDiv(String divId);

    /**
     * @param id
     * @return int
     * @Description : 设置某个记录无效
     * @author dingdongliang
     * @date 2018/2/20 19:10
     */
    int invalidByPrimaryKey(String id);
}