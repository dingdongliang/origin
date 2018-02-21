package space.dyenigma.service.impl;

import space.dyenigma.dao.SysPostRoleMapper;
import space.dyenigma.entity.BaseDomain;
import space.dyenigma.entity.SysPostRole;
import space.dyenigma.service.ISysPostRoleService;
import space.dyenigma.util.Constants;
import space.dyenigma.util.StringUtil;
import space.dyenigma.util.UUIDUtil;
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
public class SysPostRoleService extends BaseService<SysPostRole> implements
        ISysPostRoleService {
    @Autowired
    private SysPostRoleMapper sysPostRoleMapper;

    /**
     * @param postId
     * @param checkedIds 角色ID集合
     * @return boolean
     * @Description : 保存分配岗位角色
     * @author dingdongliang
     * @date 2018/2/20 19:47
     */
    @Override
    public boolean savePostRole(String postId, String checkedIds) {

        String userId = Constants.getCurrendUser().getUserId();

        //盛放没有修改以前的岗位角色对应记录，用于在修改后删除多余的记录
        Map<String, SysPostRole> map = new HashMap<>();

        //获取某岗位ID对应的所有角色
        List<SysPostRole> postRoleList = sysPostRoleMapper.findAllByPostId(postId);
        //循环处理这些岗位与角色的对应记录，逐一放入map中，然后设置该记录为过期，用于标记删除
        for (SysPostRole postRole : postRoleList) {
            String roleId = postRole.getRoleId();

            //对于岗位角色对应记录来说，角色ID是互斥的，所以当成key处理
            map.put(roleId.toString(), postRole);
            //设置所有记录过期
            updPostRole(userId, postRole, Constants.PERSISTENCE_DELETE_STATUS);
        }
        //开始处理修改后提交的对应数据，checkedIds为权限集合
        if (null != checkedIds && !"".equals(checkedIds)) {
            String[] ids = checkedIds.split(",");
            for (String id : ids) {
                if (StringUtil.isEmpty(id)) {
                    continue;
                }
                //然后看这些角色ID是否在map中
                SysPostRole sysPostRole = map.get(id);
                if (sysPostRole != null) {
                    //如果在map中，说明在数据库中有记录，把状态改成正常
                    updPostRole(userId, sysPostRole, Constants.PERSISTENCE_STATUS);
                } else {
                    //如果不在msp中，说明该对应记录在数据库中没有，要新增
                    sysPostRole = new SysPostRole();
                    BaseDomain.createLog(sysPostRole, userId);
                    sysPostRole.setStatus(Constants.PERSISTENCE_STATUS);
                    sysPostRole.setRoleId(id);
                    sysPostRole.setPostId(postId);
                    sysPostRole.setPrId(UUIDUtil.getUUID());
                    sysPostRoleMapper.insert(sysPostRole);
                }
                //同时删除已经处理过的map值
                map.remove(id);
            }
        }
        //当所有值都处理完毕以后，剩下的map值就是：原来有对应关系，修改后没有对应关系，删除之
        for (Map.Entry<String, SysPostRole> entry : map.entrySet()) {
            sysPostRoleMapper.deleteByPrimaryKey(entry.getValue().getPrId());
        }

        return true;
    }

    private void updPostRole(String userId, SysPostRole postRole, String status) {
        BaseDomain.editLog(postRole, userId);
        postRole.setStatus(status);
        sysPostRoleMapper.updateByPrimaryKeySelective(postRole);
    }

    @Override
    public List<SysPostRole> getPostRoleByPostId(String postId) {
        return sysPostRoleMapper.findAllByPostId(postId);
    }
}
