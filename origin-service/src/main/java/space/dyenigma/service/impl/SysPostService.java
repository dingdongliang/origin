package space.dyenigma.service.impl;

import space.dyenigma.dao.SysCompanyMapper;
import space.dyenigma.dao.SysDivisionMapper;
import space.dyenigma.dao.SysPostMapper;
import space.dyenigma.dao.SysPostRoleMapper;
import space.dyenigma.dao.SysUserPostMapper;
import space.dyenigma.entity.BaseDomain;
import space.dyenigma.entity.SysCompany;
import space.dyenigma.entity.SysDivision;
import space.dyenigma.entity.SysPost;
import space.dyenigma.entity.SysPostRole;
import space.dyenigma.entity.SysUserPost;
import space.dyenigma.model.TreeModel;
import space.dyenigma.service.ISysPostService;
import space.dyenigma.util.Constants;
import space.dyenigma.util.StringUtil;
import space.dyenigma.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * origin/space.dyenigma.service.impl
 *
 * @Description:
 * @Author: dingdongliang
 * @Date: 2017/07/21
 */
@Service
@Transactional
public class SysPostService extends BaseService<SysPost> implements
        ISysPostService {
    @Autowired
    private SysPostMapper sysPostMapper;
    @Autowired
    private SysCompanyMapper sysCompanyMapper;
    @Autowired
    private SysDivisionMapper sysDivisionMapper;
    @Autowired
    private SysUserPostMapper sysUserPostMapper;
    @Autowired
    private SysPostRoleMapper sysPostRoleMapper;

    /**
     * @param id
     * @return java.util.List<space.dyenigma.entity.SysPost>
     * @Description : 根据部门ID查询该部门下所有的岗位信息
     * @author dingdongliang
     * @date 2018/2/20 19:48
     */
    @Override
    public List<SysPost> finaPostByDiv(String id) {
        return sysPostMapper.findPostByDiv(id);
    }

    /**
     * @param post
     * @return java.lang.Boolean
     * @Description : 新增或修改岗位信息
     * @author dingdongliang
     * @date 2018/2/20 19:48
     */
    @Override
    public Boolean persistencePost(SysPost post) {
        String userId = Constants.getCurrendUser().getUserId();
        if (StringUtil.isEmpty(post.getPostId())) {
            BaseDomain.createLog(post, userId);
            post.setStatus(Constants.PERSISTENCE_STATUS);
            post.setPostId(UUIDUtil.getUUID());
            sysPostMapper.insert(post);
        } else {
            BaseDomain.editLog(post, userId);
            sysPostMapper.updateByPrimaryKeySelective(post);
        }
        return true;
    }

    /**
     * @param
     * @return java.util.List<space.dyenigma.model.TreeModel>
     * @Description : 获取所有可添加岗位的公司和部门
     * @author dingdongliang
     * @date 2018/2/20 19:48
     */
    @Override
    public List<TreeModel> getCoDivList() {
        //获取所有的公司信息，并用treeModel格式化
        List<SysCompany> coList = sysCompanyMapper.selectAll();
        List<TreeModel> coTrees = coToTree("0", coList);
        childToTree(coTrees);
        return coTrees;
    }

    /**
     * @param list
     * @return void
     * @Description : 添加部门数据到公司树模型下
     * @author dingdongliang
     * @date 2018/2/20 19:48
     */
    private void childToTree(List<TreeModel> list) {
        for (TreeModel treeModel : list) {
            List<TreeModel> coChild = treeModel.getChildren();
            if (coChild.size() == 0) {
                //获取每个节点的id，即公司id
                String coId = treeModel.getId();
                //获取该公司下属的所有部门
                List<SysDivision> divList = sysDivisionMapper.findByCompId(coId);
                //把部门加入公司节点内
                addDivToCo(divList, coChild);
            } else {
                List<TreeModel> childList = treeModel.getChildren();
                //内层循环，添加节点
                childToTree(childList);
                //获取每个节点的id，即公司id
                String coId = treeModel.getId();
                //获取该公司下属的所有部门
                List<SysDivision> divList = sysDivisionMapper.findByCompId(coId);
                //把部门加入公司节点内
                addDivToCo(divList, childList);
            }
        }
    }

    /**
     * @param list
     * @param childList
     * @return void
     * @Description : 把部门加入公司节点内
     * @author dingdongliang
     * @date 2018/2/20 19:48
     */
    private void addDivToCo(List<SysDivision> list, List<TreeModel> childList) {
        for (SysDivision div : list) {
            TreeModel tm = new TreeModel();
            tm.setId(div.getDivId());
            tm.setIconCls(div.getIconCls());
            tm.setPid("DIV");
            tm.setText(div.getDivName());
            tm.setState(Constants.TREE_STATUS_OPEN);
            childList.add(tm);
        }
    }

    /**
     * @param id
     * @param list
     * @return java.util.List<space.dyenigma.model.TreeModel>
     * @Description : 公司递归转化成Tree模型，支持无限级节点
     * @author dingdongliang
     * @date 2018/2/20 19:48
     */
    private List<TreeModel> coToTree(String id, List<SysCompany> list) {
        List<TreeModel> menuList = new ArrayList<>();
        list.stream().filter(co -> id.equals(co.getPrntId())).forEach(co -> {
            TreeModel menu = new TreeModel();
            menu.setState(Constants.TREE_STATUS_OPEN); //这里必须关闭节点，否则会出现无限节点
            menu.setId(co.getCoId());
            menu.setPid("0".equals(co.getPrntId()) ? "" : co.getPrntId());
            menu.setIconCls(co.getIconCls());
            menu.setText(co.getCoName());
            menu.setChildren(coToTree(co.getCoId(), list));
            menuList.add(menu);
        });
        return menuList;
    }

    @Override
    public boolean delPostById(String postId) {
        //先检查岗位下是否有用户，判断能否删除岗位
        List<SysUserPost> upList = sysUserPostMapper.findByPostId(postId);
        if (upList.size() > 0) {
            return false;
        } else {
            //没有用户的岗位可以删除，首先删除岗位角色的对应关系，然后删除岗位
            List<SysPostRole> prList = sysPostRoleMapper.findAllByPostId(postId);
            for (SysPostRole postRole : prList) {
                sysPostMapper.deleteByPrimaryKey(postRole.getPrId());
            }
            SysPost post = sysPostMapper.selectByPrimaryKey(postId);
            post.setStatus(Constants.PERSISTENCE_DELETE_STATUS);
            return sysPostMapper.updateByPrimaryKey(post) > 0;
        }
    }

    /**
     * @param id
     * @return int
     * @Description : 设置某个记录无效
     * @author dingdongliang
     * @date 2018/2/20 19:48
     */
    @Override
    public int invalidByPrimaryKey(String id) {
        return sysPostMapper.invalidByPrimaryKey(id);
    }
}
