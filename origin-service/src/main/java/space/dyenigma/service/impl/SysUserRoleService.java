package space.dyenigma.service.impl;

import space.dyenigma.dao.SysUserRoleMapper;
import space.dyenigma.entity.BaseDomain;
import space.dyenigma.entity.SysRole;
import space.dyenigma.entity.SysUserRole;
import space.dyenigma.service.ISysUserRoleService;
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
public class SysUserRoleService extends BaseService<SysUserRole> implements
        ISysUserRoleService {

    private final Logger logger = LoggerFactory.getLogger(SysUserRoleService.class);

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    /**
     * @param userId
     * @return java.util.List<space.dyenigma.entity.SysRole>
     * @Description : 好代码自己会说话
     * @author dingdongliang
     * @date 2018/2/20 19:51
     */
    @Override
    public List<SysRole> findAllByUserId(String userId) {
        logger.info("开始读取id为" + userId + "的用户信息");
        List<SysRole> rList = new ArrayList<>();
        List<SysUserRole> urList = sysUserRoleMapper.findAllByUserId(userId);
        for (SysUserRole i : urList) {
            SysRole role = new SysRole();
            role.setRoleId(i.getRoleId());
            rList.add(role);
        }
        return rList;
    }

    /**
     * @param userId
     * @param checkedIds
     * @return boolean
     * @Description : 保存分配角色权限,处理逻辑：根据用户查找所有的已有角色信息，然后全部删除，最后赋予新角色
     * @author dingdongliang
     * @date 2018/2/20 19:51
     */
    @Override
    public boolean saveRole(String userId, String checkedIds) {

        String currentUserId = Constants.getCurrendUser().getUserId();

        //盛放没有修改以前的对应记录，用于在修改后删除多余的记录
        Map<String, SysUserRole> map = new HashMap<>();

        //获取ID对应的所有权限
        List<SysUserRole> urList = sysUserRoleMapper.findAllByUserId(userId);

        //循环处理这些对应记录，逐一放入map中，然后设置该记录为过期，用于标记删除
        for (SysUserRole userRole : urList) {
            //对于该对应记录来说，互斥的ID当成key处理
            map.put(userRole.getRoleId(), userRole);
            //设置所有记录过期
            updUserRole(currentUserId, userRole, Constants.PERSISTENCE_DELETE_STATUS);
        }

        //开始处理修改后提交的对应数据，checkedIds为权限集合
        if (null != checkedIds && !"".equals(checkedIds)) {
            String[] ids = checkedIds.split(",");
            for (String id : ids) {
                if (StringUtil.isEmpty(id)) {
                    continue;
                }
                //然后看这些ID是否在map中
                SysUserRole userRole = map.get(id);
                if (userRole != null) {
                    //如果在map中，说明在数据库中有记录，把状态改成正常
                    updUserRole(userId, userRole, Constants.PERSISTENCE_STATUS);
                } else {
                    //如果不在msp中，说明该对应记录在数据库中没有，要新增
                    userRole = new SysUserRole();
                    BaseDomain.createLog(userRole, userId);
                    userRole.setStatus(Constants.PERSISTENCE_STATUS);
                    //循环处理的ID
                    userRole.setRoleId(id);
                    //传递过来的Id
                    userRole.setUserId(userId);
                    userRole.setUrId(UUIDUtil.getUUID());
                    sysUserRoleMapper.insert(userRole);
                }
                //同时删除已经处理过的map值
                map.remove(id);
            }
        }
        //当所有值都处理完毕以后，剩下的map值就是：原来有对应关系，修改后没有对应关系，删除之
        for (Map.Entry<String, SysUserRole> entry : map.entrySet()) {
            sysUserRoleMapper.deleteByPrimaryKey(entry.getValue().getUrId());
        }

        return true;
    }

    private void updUserRole(String userId, SysUserRole userRole, String status) {
        BaseDomain.editLog(userRole, userId);
        userRole.setStatus(status);
        sysUserRoleMapper.updateByPrimaryKeySelective(userRole);
    }

    /**
     * @param userId
     * @return java.util.List<space.dyenigma.entity.SysUserRole>
     * @Description : 根据用户ID获取所有用户角色映射关系
     * @author dingdongliang
     * @date 2018/2/20 19:51
     */
    @Override
    public List<SysUserRole> findByUserId(String userId) {
        return sysUserRoleMapper.findAllByUserId(userId);
    }
}
