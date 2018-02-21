package space.dyenigma.service.impl;

import space.dyenigma.dao.SysPrjRoleMapper;
import space.dyenigma.dao.SysPrjUserMapper;
import space.dyenigma.dao.SysProjectMapper;
import space.dyenigma.entity.BaseDomain;
import space.dyenigma.entity.SysPrjRole;
import space.dyenigma.entity.SysPrjUser;
import space.dyenigma.entity.SysProject;
import space.dyenigma.entity.SysUser;
import space.dyenigma.service.ISysProjectService;
import space.dyenigma.util.Constants;
import space.dyenigma.util.StringUtil;
import space.dyenigma.util.UUIDUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * origin/space.dyenigma.service.impl
 *
 * @Description:
 * @Author: dingdongliang
 * @Date: 2017/07/21
 */
@Service
@Transactional
public class SysProjectService extends BaseService<SysProject> implements
        ISysProjectService {

    private static final Logger logger = LoggerFactory.getLogger(SysProjectService.class);

    @Autowired
    private SysProjectMapper sysProjectMapper;
    @Autowired
    private SysPrjRoleMapper sysPrjRoleMapper;
    @Autowired
    private SysPrjUserMapper sysPrjUserMapper;

    /**
     * @param coId
     * @return java.util.List<space.dyenigma.entity.SysProject>
     * @Description : 查询公司所属项目组信息
     * @author dingdongliang
     * @date 2018/2/20 19:49
     */
    @Override
    public List<SysProject> getPrjByCoId(String coId) {
        return sysProjectMapper.getPrjByCoId(coId);
    }

    /**
     * @param prj
     * @return boolean
     * @Description : 实例化项目组信息
     * @author dingdongliang
     * @date 2018/2/20 19:49
     */
    @Override
    public boolean persistencePrj(SysProject prj) {
        String userId = Constants.getCurrendUser().getUserId();

        if (StringUtil.isEmpty(prj.getPrjId())) {
            BaseDomain.createLog(prj, userId);
            prj.setStatus(Constants.PERSISTENCE_STATUS);
            prj.setPrjId(UUIDUtil.getUUID());
            sysProjectMapper.insert(prj);
        } else {

            BaseDomain.editLog(prj, userId);
            sysProjectMapper.updateByPrimaryKeySelective(prj);
        }
        return true;
    }

    /**
     * @param prjId
     * @return boolean
     * @Description : 删除项目组
     * @author dingdongliang
     * @date 2018/2/20 19:49
     */
    @Override
    public boolean delPrj(String prjId) {

        List<SysPrjUser> prjUserList = sysPrjUserMapper.getPrjUserByPrjId(prjId);
        if (prjUserList.size() > 0) {
            return false;
        } else {
            List<SysPrjRole> prjRoleList = sysPrjRoleMapper.findAllByPrjId(prjId);
            for (SysPrjRole prjRole : prjRoleList) {
                sysProjectMapper.deleteByPrimaryKey(prjRole.getPrId());
            }

            SysProject prj = sysProjectMapper.selectByPrimaryKey(prjId);
            prj.setStatus(Constants.PERSISTENCE_DELETE_STATUS);
            return sysProjectMapper.updateByPrimaryKey(prj) > 0;
        }
    }

    /**
     * @param prjId
     * @param checkedIds
     * @return boolean
     * @Description : 保存分配给项目组的角色
     * @author dingdongliang
     * @date 2018/2/20 19:49
     */
    @Override
    public boolean savePrjRole(String prjId, String checkedIds) {
        String userId = Constants.getCurrendUser().getUserId();

        //盛放没有修改以前的对应记录，用于在修改后删除多余的记录
        Map<String, SysPrjRole> map = new HashMap<>();

        //获取某ID对应的所有角色
        List<SysPrjRole> prjRoleList = sysPrjRoleMapper.findAllByPrjId(prjId);
        //循环处理这些岗位与角色的对应记录，逐一放入map中，然后设置该记录为过期，用于标记删除
        for (SysPrjRole prjRole : prjRoleList) {
            String roleId = prjRole.getRoleId();

            //对于岗位角色对应记录来说，角色ID是互斥的，所以当成key处理
            map.put(roleId, prjRole);
            //设置所有记录过期
            updPrjRole(userId, prjRole, Constants.PERSISTENCE_DELETE_STATUS);
        }
        //开始处理修改后提交的对应数据，checkedIds为权限集合
        if (null != checkedIds && !"".equals(checkedIds)) {
            String[] ids = checkedIds.split(",");
            for (String id : ids) {
                if (StringUtil.isEmpty(id)) {
                    continue;
                }
                //然后看这些角色ID是否在map中
                SysPrjRole prjRole = map.get(id);
                if (prjRole != null) {
                    //如果在map中，说明在数据库中有记录，把状态改成正常
                    updPrjRole(userId, prjRole, Constants.PERSISTENCE_STATUS);
                } else {
                    //如果不在msp中，说明该对应记录在数据库中没有，要新增
                    prjRole = new SysPrjRole();
                    BaseDomain.createLog(prjRole, userId);
                    prjRole.setStatus(Constants.PERSISTENCE_STATUS);
                    prjRole.setRoleId(id);
                    prjRole.setPrjId(prjId);
                    prjRole.setPrId(UUIDUtil.getUUID());
                    sysPrjRoleMapper.insert(prjRole);
                }
                //同时删除已经处理过的map值
                map.remove(id);
            }
        }
        //当所有值都处理完毕以后，剩下的map值就是：原来有对应关系，修改后没有对应关系，删除之
        for (Map.Entry<String, SysPrjRole> entry : map.entrySet()) {
            sysPrjRoleMapper.deleteByPrimaryKey(entry.getValue().getPrId());
        }

        return true;
    }

    private void updPrjRole(String userId, SysPrjRole prjRole, String status) {
        BaseDomain.editLog(prjRole, userId);
        prjRole.setStatus(status);
        int i = sysPrjRoleMapper.updateByPrimaryKeySelective(prjRole);
        logger.info("返回值为%d", i);
    }

    /**
     * @param prjId
     * @return java.util.List<space.dyenigma.entity.SysUser>
     * @Description : 查找项目组成员
     * @author dingdongliang
     * @date 2018/2/20 19:49
     */
    @Override
    public List<SysUser> searchPrjUser(String prjId) {
        //首先查找prjUser表，找到对应关系，获取userId
        //然后使用userId查询用户集合返回
        return null;
    }

    /**
     * @param prjId
     * @param checkedIds
     * @return boolean
     * @Description : 保存分配给项目组的角色
     * @author dingdongliang
     * @date 2018/2/20 19:49
     */
    @Override
    public boolean savePrjUsers(String prjId, String checkedIds) {
        String userId = Constants.getCurrendUser().getUserId();

        //盛放没有修改以前的对应记录，用于在修改后删除多余的记录
        Map<String, SysPrjUser> map = new HashMap<>();

        //获取某ID对应的所有角色
        List<SysPrjUser> prjUserList = sysPrjUserMapper.getPrjUserByPrjId(prjId);
        //循环处理这些岗位与角色的对应记录，逐一放入map中，然后设置该记录为过期，用于标记删除
        for (SysPrjUser prjUser : prjUserList) {
            String roleId = prjUser.getUserId();

            //对于岗位角色对应记录来说，角色ID是互斥的，所以当成key处理
            map.put(roleId, prjUser);
            //设置所有记录过期
            updPrjUser(userId, prjUser, Constants.PERSISTENCE_DELETE_STATUS);
        }
        //开始处理修改后提交的对应数据，checkedIds为权限集合
        if (null != checkedIds && !"".equals(checkedIds)) {
            String[] ids = checkedIds.split(",");
            for (String id : ids) {
                if (StringUtil.isEmpty(id)) {
                    continue;
                }
                //然后看这些角色ID是否在map中
                SysPrjUser prjUser = map.get(id);
                if (prjUser != null) {
                    //如果在map中，说明在数据库中有记录，把状态改成正常
                    updPrjUser(userId, prjUser, Constants.PERSISTENCE_STATUS);
                } else {
                    //如果不在msp中，说明该对应记录在数据库中没有，要新增
                    prjUser = new SysPrjUser();
                    BaseDomain.createLog(prjUser, userId);
                    prjUser.setStatus(Constants.PERSISTENCE_STATUS);
                    prjUser.setUserId(id);
                    prjUser.setPrjId(prjId);
                    prjUser.setPuId(UUIDUtil.getUUID());
                    sysPrjUserMapper.insert(prjUser);
                }
                //同时删除已经处理过的map值
                map.remove(id);
            }
        }
        //当所有值都处理完毕以后，剩下的map值就是：原来有对应关系，修改后没有对应关系，删除之
        for (Map.Entry<String, SysPrjUser> entry : map.entrySet()) {
            sysPrjUserMapper.deleteByPrimaryKey(entry.getValue().getPuId());
        }

        return true;
    }

    private void updPrjUser(String userId, SysPrjUser prjUser, String status) {
        BaseDomain.editLog(prjUser, userId);
        prjUser.setStatus(status);
        sysPrjUserMapper.updateByPrimaryKeySelective(prjUser);
    }
}
