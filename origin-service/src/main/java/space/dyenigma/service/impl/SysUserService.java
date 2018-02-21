package space.dyenigma.service.impl;

import space.dyenigma.dao.SysPostMapper;
import space.dyenigma.dao.SysPrjUserMapper;
import space.dyenigma.dao.SysRoleMapper;
import space.dyenigma.dao.SysUserMapper;
import space.dyenigma.dao.SysUserPmsnMapper;
import space.dyenigma.dao.SysUserPostMapper;
import space.dyenigma.dao.SysUserRoleMapper;
import space.dyenigma.entity.BaseDomain;
import space.dyenigma.entity.SysPost;
import space.dyenigma.entity.SysPrjUser;
import space.dyenigma.entity.SysRole;
import space.dyenigma.entity.SysUser;
import space.dyenigma.entity.SysUserPmsn;
import space.dyenigma.entity.SysUserPost;
import space.dyenigma.entity.SysUserRole;
import space.dyenigma.model.TreeModel;
import space.dyenigma.service.ISysUserService;
import space.dyenigma.util.Constants;
import space.dyenigma.util.PageUtil;
import space.dyenigma.util.StringUtil;
import space.dyenigma.util.UUIDUtil;
import space.dyenigma.util.security.Md5Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * origin/space.dyenigma.service.impl
 *
 * @Description:
 * @Author: dingdongliang
 * @Date: 2017/07/21
 */
@Service
@Transactional
public class SysUserService extends BaseService<SysUser> implements
        ISysUserService {

    private final Logger logger = LoggerFactory.getLogger(SysUserService.class);

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    @Autowired
    private SysUserPmsnMapper sysUserPmsnMapper;
    @Autowired
    private SysUserPostMapper sysUserPostMapper;
    @Autowired
    private SysPrjUserMapper sysPrjUserMapper;
    @Autowired
    private SysPostMapper sysPostMapper;

    @Override
    public List<SysUser> findAll() {
        logger.debug("run the users findall");
        return sysUserMapper.selectAll();
    }

    @Override
    public SysUser getUserByName(String name) {

        return sysUserMapper.findByName(name);
    }

    @Override
    public boolean persistenceUser(SysUser sysUser) {
        String userId = Constants.getCurrendUser().getUserId();

        if (StringUtil.isEmpty(sysUser.getUserId())) {
            BaseDomain.createLog(sysUser, userId);
            sysUser.setPassword(Md5Utils.hash(Constants.DEFAULT_PASSWORD));
            sysUser.setStatus(Constants.PERSISTENCE_STATUS);
            sysUser.setUserId(UUIDUtil.getUUID());
            sysUserMapper.insert(sysUser);

            List<SysRole> rList = sysRoleMapper.findDefaultRole();
            for (SysRole role : rList) {
                SysUserRole userRole = new SysUserRole();
                BaseDomain.createLog(userRole, userId);
                userRole.setUrId(UUIDUtil.getUUID());
                userRole.setUserId(sysUser.getUserId());
                userRole.setRoleId(role.getRoleId());
                userRole.setStatus(Constants.PERSISTENCE_STATUS);
                sysUserRoleMapper.insert(userRole);
            }

        } else {
            BaseDomain.editLog(sysUser, userId);
            sysUserMapper.updateByPrimaryKeySelective(sysUser);
        }
        return true;
    }

    /**
     * @param pageUtil
     * @return java.util.List<space.dyenigma.entity.SysUser>
     * @Description : 分页查询用户信息
     * @author dingdongliang
     * @date 2018/2/20 19:52
     */
    @Override
    public List<SysUser> allUserByPage(PageUtil pageUtil) {
        logger.info("开始查找用户信息,分页显示");
        return sysUserMapper.findAllByPage(pageUtil);
    }

    @Override
    public boolean delUser(String userId) {
        //删除用户角色映射
        List<SysUserRole> urList = sysUserRoleMapper.findAllByUserId(userId);
        for (SysUserRole userRole : urList) {
            sysUserMapper.deleteByPrimaryKey(userRole.getUrId());
        }

        //删除用户权限映射
        List<SysUserPmsn> upList = sysUserPmsnMapper.findAllByUserId(userId);
        for (SysUserPmsn userPmsn : upList) {
            sysUserMapper.deleteByPrimaryKey(userPmsn.getUpmId());
        }

        //删除用户岗位映射
        List<SysUserPost> userPostList = sysUserPostMapper.findAllByUserId(userId);
        for (SysUserPost userPost : userPostList) {
            sysUserMapper.deleteByPrimaryKey(userPost.getUpId());
        }
        //删除项目组用户映射
        List<SysPrjUser> prjUserList = sysPrjUserMapper.findAllByUserId(userId);
        for (SysPrjUser prjUser : prjUserList) {
            sysUserMapper.deleteByPrimaryKey(prjUser.getPuId());
        }
        //删除用户

        SysUser user = sysUserMapper.selectByPrimaryKey(userId);
        user.setStatus(Constants.PERSISTENCE_DELETE_STATUS);
        return sysUserMapper.updateByPrimaryKey(user) > 0;

    }

    /**
     * @param list 传递过来公司与部门树
     * @return java.util.List<space.dyenigma.model.TreeModel>
     * @Description : 获取所有可添加用户的岗位，按树状结构展示 1.循环判断该树中哪个节点是部门节点 2.然后查找该节点的下属岗位 3.添加到节点内
     * @author dingdongliang
     * @date 2018/2/20 19:52
     */
    @Override
    public List<TreeModel> getPostList(List<TreeModel> list) {
        //递归处理树结构，添加岗位信息
        postToTree(list);
        return list;
    }

    /**
     * @param list
     * @return void
     * @Description : 添加岗位数据到公司-部门树模型下（第一步处理方法：判断是否有子节点）
     * @author dingdongliang
     * @date 2018/2/20 19:53
     */
    private void postToTree(List<TreeModel> list) {
        for (TreeModel treeModel : list) {
            List<TreeModel> children = treeModel.getChildren();
            //有子节点递归，没有子节点不参与递归，在每个部门节点处理岗位信息的嫁接
            if (children == null || children.size() == 0) {
                addPost(treeModel, children);
            } else {
                List<TreeModel> childList = treeModel.getChildren();
                //内层循环，添加节点
                postToTree(childList);
                addPost(treeModel, children);
            }
        }
    }

    /**
     * @param treeModel
     * @param children
     * @return void
     * @Description : 添加岗位数据到公司-部门树模型下（第二步处理方法：判断是否是部门节点）
     * @author dingdongliang
     * @date 2018/2/20 19:53
     */
    private void addPost(TreeModel treeModel, List<TreeModel> children) {
        //判断是否是部门节点
        if ("DIV".equals(treeModel.getPid())) {
            //获取每个节点的id，即部门id
            String divId = treeModel.getId();
            //获取该部门下属的所有岗位
            List<SysPost> postList = sysPostMapper.findPostByDiv(divId);
            //把岗位加入部门节点内
            treeModel.setChildren(addPostToDiv(postList, children));
        }
    }

    /**
     * @param list
     * @param childList
     * @return java.util.List<space.dyenigma.model.TreeModel>
     * @Description : 添加岗位数据到公司-部门树模型下（第三步处理方法：把岗位加入部门节点内）
     * @author dingdongliang
     * @date 2018/2/20 19:53
     */
    private List<TreeModel> addPostToDiv(List<SysPost> list, List<TreeModel> childList) {
        if (childList == null) {
            childList = new ArrayList<>();
        }
        for (SysPost post : list) {
            TreeModel tm = new TreeModel();
            tm.setId(post.getPostId());
            tm.setIconCls(Constants.DEFAULT_ICON);
            tm.setPid("POST");
            tm.setText(post.getPostName());
            tm.setState(Constants.TREE_STATUS_OPEN);
            childList.add(tm);
        }
        return childList;
    }

    /**
     * @param pageUtil
     * @param idList
     * @return java.util.List<space.dyenigma.entity.SysUser>
     * @Description : 按用户ID集合查询用户信息，分页，用于获取岗位、部门、公司的所有用户信息
     * @author dingdongliang
     * @date 2018/2/20 19:53
     */
    @Override
    public List<SysUser> findUserByPage(PageUtil pageUtil, Set<String> idList) {
        return sysUserMapper.findUserByPage(pageUtil, idList);
    }
}
