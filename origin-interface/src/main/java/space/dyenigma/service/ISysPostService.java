package space.dyenigma.service;

import space.dyenigma.entity.SysPost;
import space.dyenigma.model.TreeModel;

import java.util.List;

/**
 * origin/space.dyenigma.service
 *
 * @Description:
 * @Author: dingdongliang
 * @Date: 2017/07/21
 */
public interface ISysPostService extends IBaseService<SysPost> {
    /**
     * @param id
     * @return java.util.List<space.dyenigma.entity.SysPost>
     * @Description : 根据部门ID查询该部门下所有的岗位信息
     * @author dingdongliang
     * @date 2018/2/20 19:23
     */
    List<SysPost> finaPostByDiv(String id);

    /**
     * @param post
     * @return java.lang.Boolean
     * @Description : 新增或修改岗位信息
     * @author dingdongliang
     * @date 2018/2/20 19:23
     */
    Boolean persistencePost(SysPost post);

    /**
     * @param
     * @return java.util.List<space.dyenigma.model.TreeModel>
     * @Description : 获取所有可添加岗位的公司和部门
     * @author dingdongliang
     * @date 2018/2/20 19:23
     */
    List<TreeModel> getCoDivList();

    boolean delPostById(String postId);

    /**
     * @param id
     * @return int
     * @Description : 设置某个记录无效
     * @author dingdongliang
     * @date 2018/2/20 19:23
     */
    int invalidByPrimaryKey(String id);
}
