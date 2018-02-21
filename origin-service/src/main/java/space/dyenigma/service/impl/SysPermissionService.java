package space.dyenigma.service.impl;

import space.dyenigma.dao.SysPermissionMapper;
import space.dyenigma.dao.SysRolePmsnMapper;
import space.dyenigma.dao.SysUserPmsnMapper;
import space.dyenigma.entity.BaseDomain;
import space.dyenigma.entity.SysPermission;
import space.dyenigma.model.MenuModel;
import space.dyenigma.model.MultiMenu;
import space.dyenigma.model.TreeModel;
import space.dyenigma.service.ISysPermissionService;
import space.dyenigma.shiro.ShiroUser;
import space.dyenigma.util.Constants;
import space.dyenigma.util.StringUtil;
import space.dyenigma.util.UUIDUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * @Date: 2016/4/2 18:47
 */
@Service
@Transactional
public class SysPermissionService extends BaseService<SysPermission> implements
        ISysPermissionService {

    private final Logger logger = LoggerFactory.getLogger(SysPermissionService.class);

    @Autowired
    private SysPermissionMapper sysPermissionMapper;
    @Autowired
    private SysRolePmsnMapper sysRolePmsnMapper;
    @Autowired
    private SysUserPmsnMapper sysUserPmsnMapper;

    @Override
    public List<MenuModel> createMenu() {

        List<SysPermission> pList = getShiro(Constants.PMSN_M);

        // 用于存放根目录的List
        List<MenuModel> parentList = new ArrayList<>();
        // 循环的逻辑：首先遍历所有记录，当PrntId为空时，该记录为根目录，因菜单格式布局，只显示两级菜单
        for (SysPermission parent : pList) {
            String id = String.valueOf(parent.getPmsnId());
            if ("0".equals(parent.getPrntId())) {
                MenuModel menuModel = new MenuModel();
                menuModel.setId(id);
                menuModel.setName(String.valueOf(parent.getPmsnName()));
                menuModel.setIconCls(String.valueOf(parent.getIconCls()));
                menuModel.setUrl(String.valueOf(parent.getPmsnUrl()));
                List<MenuModel> childList = new ArrayList<>();
                for (SysPermission child : pList) {
                    MenuModel menuChildModel = new MenuModel();
                    String sid = String.valueOf(child.getPrntId());
                    if (sid.equals(id)) {
                        menuChildModel.setId(String.valueOf(child.getPmsnId()));
                        menuChildModel.setPid(sid);
                        menuChildModel.setName(String.valueOf(child.getPmsnName()));
                        menuChildModel.setIconCls(String.valueOf(child.getIconCls()));
                        menuChildModel.setUrl(String.valueOf(child.getPmsnUrl()));
                        childList.add(menuChildModel);
                    }
                }
                menuModel.setChild(childList);
                parentList.add(menuModel);
            }
        }
        return parentList;
    }

    @Override
    public List<SysPermission> getShiro(String type) {
        ShiroUser user = Constants.getCurrendUser();
        logger.debug("获取权限user====>" + user);
        List<SysPermission> pList;
        // 超级管理员默认拥有所有功能权限
        if (Constants.SYSTEM_ADMINISTRATOR.equals(user.getAccount())) {
            pList = sysPermissionMapper.adminMenu(type);
        } else {
            pList = sysPermissionMapper.usersMenu(user.getUserId(), type);
        }
        return pList;
    }

    @Override
    public List<SysPermission> findByPid(String pid) {
        List<SysPermission> pList = StringUtil.isEmpty(pid) ?
                sysPermissionMapper.findRootMenu() : sysPermissionMapper.findByPid(pid);
        pList.stream().filter(permission -> StringUtil.isEmpty(pid)).forEach(permission -> permission.setPrntId("0"));
        return pList;
    }

    /**
     * @param id
     * @return boolean
     * @Description : 删除菜单 1.如果包含子菜单，不能删除 2.满足上面的条件，先删除用户权限映射和角色权限映射后再删除
     * @author dingdongliang
     * @date 2018/2/20 19:47
     */
    @Override
    public boolean deleteById(String id) {

        //如果包含有子菜单，则不能删除
        List<SysPermission> pList = sysPermissionMapper.findByPid(id);

        if (pList.size() > 0) {
            return false;
        } else {
            sysUserPmsnMapper.delByPmsnId(id);//删除用户权限映射
            sysRolePmsnMapper.delByPmsnId(id);//删除角色权限映射
            SysPermission pmsn = mapper.selectByPrimaryKey(id);
            pmsn.setStatus(Constants.PERSISTENCE_DELETE_STATUS);
            return sysPermissionMapper.updateByPrimaryKey(pmsn) > 0;
        }
    }

    @Override
    public List<TreeModel> findSuperFunc() {
        List<SysPermission> pList = sysPermissionMapper.findSuperFunc();
        return permToTree("0", pList);
    }

    /**
     * @param id
     * @param list
     * @return java.util.List<space.dyenigma.model.TreeModel>
     * @Description : 递归转化成菜单模型，支持无限级菜单
     * @author dingdongliang
     * @date 2018/2/20 19:47
     */
    private List<TreeModel> permToTree(String id, List<SysPermission> list) {
        List<TreeModel> menuList = new ArrayList<>();
        list.stream().filter(perm -> id.equals(perm.getPrntId())).forEach(perm -> {
            if (Constants.TREE_STATUS_OPEN.equals(perm.getState())) {
                return; //lambda表达式循环用return跳到下一项，相当于continue
            } else {
                TreeModel menu = new TreeModel();
                menu.setState(Constants.TREE_STATUS_OPEN); //这里必须关闭节点，否则会出现无限节点
                menu.setId(perm.getPmsnId());
                menu.setPid("0".equals(perm.getPrntId()) ? "" : perm.getPrntId());
                menu.setIconCls(perm.getIconCls());
                menu.setText(perm.getPmsnName());
                menu.setChildren(permToTree(perm.getPmsnId(), list));
                menuList.add(menu);
            }
        });
        return menuList;
    }

    @Override
    public boolean persistenceFunction(SysPermission permission) {
        String userId = Constants.getCurrendUser().getUserId();
        if (StringUtil.isEmpty(permission.getPmsnId())) {
            BaseDomain.createLog(permission, userId);
            permission.setStatus(Constants.PERSISTENCE_STATUS);
            if (Constants.PMSN_M.equals(permission.getPmsnType())) {
                permission.setState(Constants.TREE_STATUS_CLOSED);
            } else {
                permission.setState(Constants.TREE_STATUS_OPEN);
            }
            //因permission的Pid是Integer类型，默认为null，要改成0
            if (StringUtil.isEmpty(permission.getPrntId())) {
                permission.setPrntId("0");
            }
            permission.setPmsnId(UUIDUtil.getUUID());
            sysPermissionMapper.insert(permission);
        } else {
            //这里还要考虑如果修改菜单名称，同步修改其子菜单对应的prntName名称，关系不大
            if (Constants.PMSN_M.equals(permission.getPmsnType())) {
                permission.setState(Constants.TREE_STATUS_CLOSED);
            } else {
                permission.setState(Constants.TREE_STATUS_OPEN);
            }
            BaseDomain.editLog(permission, userId);
            sysPermissionMapper.updateByPrimaryKeySelective(permission);
        }
        return true;
    }

    /**
     * @param
     * @return java.util.List<space.dyenigma.model.MultiMenu>
     * @Description : 获取所有的权限，用于角色权限分配
     * @author dingdongliang
     * @date 2018/2/20 19:47
     */
    @Override
    public List<MultiMenu> multiMenu() {
        List<SysPermission> list = sysPermissionMapper.findAllMenu();
        return permToMenu("0", list);
    }

    /**
     * @param id
     * @param list
     * @return java.util.List<space.dyenigma.model.MultiMenu>
     * @Description : 递归转化成菜单模型，支持无限极菜单模型
     * @author dingdongliang
     * @date 2018/2/20 19:47
     */
    private List<MultiMenu> permToMenu(String id, List<SysPermission> list) {
        List<MultiMenu> menuList = new ArrayList<>();
        list.stream().filter(perm -> id.equals(perm.getPrntId())).forEach(perm -> {
            MultiMenu menu = new MultiMenu();
            menu.setId(perm.getPmsnId());
            menu.setPid("0".equals(perm.getPrntId()) ? "" : perm.getPrntId());
            menu.setIconCls(perm.getIconCls());
            menu.setName(perm.getPmsnName());
            menu.setPath(perm.getPmsnUrl());
            menu.setMyid(perm.getPmsnCode());
            menu.setpName(perm.getPrntName());
            menu.setSort(perm.getSort() + "");
            menu.setType(perm.getPmsnType());
            menu.setDescription(perm.getPmsnDesc());
            menu.setIfUsed(perm.getIsUsed());
            menu.setChildren(permToMenu(perm.getPmsnId(), list));
            menuList.add(menu);
        });
        return menuList;
    }
}
