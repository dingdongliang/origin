package space.dyenigma.service.impl;

import space.dyenigma.dao.SysPermissionMapper;
import space.dyenigma.dao.SysRolePmsnMapper;
import space.dyenigma.entity.BaseDomain;
import space.dyenigma.entity.SysPermission;
import space.dyenigma.entity.SysRolePmsn;
import space.dyenigma.service.ISysRolePmsnService;
import space.dyenigma.util.Constants;
import space.dyenigma.util.StringUtil;
import space.dyenigma.util.UUIDUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
public class SysRolePmsnService extends BaseService<SysRolePmsn> implements
        ISysRolePmsnService {

    private final Logger logger = LoggerFactory.getLogger(SysRolePmsnService.class);

    @Autowired
    private SysRolePmsnMapper sysRolePmsnMapper;
    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public List<SysPermission> findAllByRoleId(String roleId) {
        logger.info("开始读取id为" + roleId + "的角色权限信息");
        List<SysPermission> permissions = new ArrayList<>();
        List<SysRolePmsn> idList = sysRolePmsnMapper.findAllByRoleId(roleId);
        for (SysRolePmsn rolePmsn : idList) {
            SysPermission permission = sysPermissionMapper.selectByPrimaryKey(rolePmsn.getPmsnId());
            permissions.add(permission);
        }
        return permissions;
    }

    /**
     * @param roleId
     * @param checkedIds
     * @return boolean
     * @Description : 保存选取的权限与角色映射
     * @author dingdongliang
     * @date 2018/2/20 19:49
     */
    @Override
    public boolean savePermission(String roleId, String checkedIds) {
        String userId = Constants.getCurrendUser().getUserId();

        //盛放没有修改以前的角色权限对应记录，用于在修改后删除多余的记录
        Map<String, SysRolePmsn> map = new HashMap<>();

        //获取某角色ID对应的所有权限
        List<SysRolePmsn> rolePermissionList = sysRolePmsnMapper.findAllByRoleId(roleId);
        //循环处理这些权限与角色的对应记录，逐一放入map中，然后设置该记录为过期，用于标记删除
        for (SysRolePmsn rolePmsn : rolePermissionList) {
            String permissionId = rolePmsn.getPmsnId();
            //对于角色权限对应记录来说，权限ID是互斥的，所以当成key处理
            map.put(permissionId.toString(), rolePmsn);
            //设置所有记录过期
            updRolePermission(userId, rolePmsn, Constants.PERSISTENCE_DELETE_STATUS);
        }
        //开始处理修改后提交的对应数据，checkedIds为权限集合
        if (null != checkedIds && !"".equals(checkedIds)) {
            String[] ids = checkedIds.split(",");
            for (String id : ids) {
                if (StringUtil.isEmpty(id)) {
                    continue;
                }
                //然后看这些权限ID是否在map中
                SysRolePmsn rolePmsn = map.get(id);
                if (rolePmsn != null) {
                    //如果在map中，说明在数据库中有记录，把状态改成正常
                    updRolePermission(userId, rolePmsn, Constants.PERSISTENCE_STATUS);
                } else {
                    //如果不在msp中，说明该对应记录在数据库中没有，要新增
                    rolePmsn = new SysRolePmsn();
                    BaseDomain.createLog(rolePmsn, userId);
                    rolePmsn.setStatus(Constants.PERSISTENCE_STATUS);
                    rolePmsn.setPmsnId(id);
                    rolePmsn.setRoleId(roleId);
                    rolePmsn.setRpId(UUIDUtil.getUUID());
                    sysRolePmsnMapper.insert(rolePmsn);
                }
                //同时删除已经处理过的map值
                map.remove(id);
            }
        }
        //当所有值都处理完毕以后，剩下的map值就是：原来有对应关系，修改后没有对应关系，删除之
        for (Map.Entry<String, SysRolePmsn> entry : map.entrySet()) {
            sysRolePmsnMapper.deleteByPrimaryKey(entry.getValue().getRpId());
        }

        return true;
    }

    private void updRolePermission(String userId, SysRolePmsn rolePermission, String status) {
        BaseDomain.editLog(rolePermission, userId);
        rolePermission.setStatus(status);
        sysRolePmsnMapper.updateByPrimaryKeySelective(rolePermission);
    }

    @Override
    public boolean setDefaultRole(String roleId) {
        String userId = Constants.getCurrendUser().getUserId();

        //获取所有的默认权限
        List<SysPermission> pList = sysPermissionMapper.findAllDefault();
        //获取默认权限的父节点
        Set<SysPermission> pSet = new HashSet<>();
        for (SysPermission permission : pList) {
            pSet.add(permission);
            getPrntPmsn(pSet, permission);
        }
        //把所有的权限节点映射到角色上
        for (SysPermission pmsn : pSet) {
            SysRolePmsn rolePmsn = new SysRolePmsn();
            BaseDomain.createLog(rolePmsn, userId);
            rolePmsn.setRpId(UUIDUtil.getUUID());
            rolePmsn.setRoleId(roleId);
            rolePmsn.setPmsnId(pmsn.getPmsnId());
            rolePmsn.setStatus(Constants.PERSISTENCE_STATUS);
            sysRolePmsnMapper.insert(rolePmsn);
        }

        return true;
    }

    private void getPrntPmsn(Set<SysPermission> pSet, SysPermission pmsn) {
        String pId = pmsn.getPrntId();
        if (!"0".equals(pId)) {
            SysPermission prntPmsn = sysPermissionMapper.selectByPrimaryKey(pId);
            pSet.add(prntPmsn);
            getPrntPmsn(pSet, prntPmsn);
        }
    }
}
