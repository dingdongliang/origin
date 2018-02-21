package space.dyenigma.service.impl;

import space.dyenigma.dao.SysUserPmsnMapper;
import space.dyenigma.entity.BaseDomain;
import space.dyenigma.entity.SysUserPmsn;
import space.dyenigma.service.ISysUserPmsnService;
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
public class SysUserPmsnService extends BaseService<SysUserPmsn> implements
        ISysUserPmsnService {
    @Autowired
    private SysUserPmsnMapper sysUserPmsnMapper;

    /**
     * @param userId
     * @param checkedIds
     * @return boolean
     * @Description :  保存分配用户权限
     * @author dingdongliang
     * @date 2018/2/20 19:50
     */
    @Override
    public boolean saveUserPmsn(String userId, String checkedIds) {

        String currentUserId = Constants.getCurrendUser().getUserId();

        //盛放没有修改以前的对应记录，用于在修改后删除多余的记录
        Map<String, SysUserPmsn> map = new HashMap<>();

        //获取ID对应的所有权限
        List<SysUserPmsn> urList = sysUserPmsnMapper.findAllByUserId(userId);
        //循环处理这些对应记录，逐一放入map中，然后设置该记录为过期，用于标记删除
        for (SysUserPmsn userPmsn : urList) {
            //对于该对应记录来说，互斥的ID当成key处理
            map.put(userPmsn.getPmsnId(), userPmsn);
            //设置所有记录过期
            updUserPmsn(currentUserId, userPmsn, Constants.PERSISTENCE_DELETE_STATUS);
        }

        //开始处理修改后提交的对应数据，checkedIds为权限集合
        if (null != checkedIds && !"".equals(checkedIds)) {
            String[] ids = checkedIds.split(",");
            for (String id : ids) {
                if (StringUtil.isEmpty(id)) {
                    continue;
                }
                //然后看这些权限ID是否在map中
                SysUserPmsn userPmsn = map.get(id);
                if (userPmsn != null) {
                    //如果在map中，说明在数据库中有记录，把状态改成正常
                    updUserPmsn(userId, userPmsn, Constants.PERSISTENCE_STATUS);
                } else {
                    //如果不在msp中，说明该对应记录在数据库中没有，要新增
                    userPmsn = new SysUserPmsn();
                    BaseDomain.createLog(userPmsn, userId);
                    userPmsn.setStatus(Constants.PERSISTENCE_STATUS);
                    //循环处理的ID
                    userPmsn.setPmsnId(id);
                    //传递过来的Id
                    userPmsn.setUserId(userId);
                    userPmsn.setUpmId(UUIDUtil.getUUID());
                    sysUserPmsnMapper.insert(userPmsn);
                }
                //同时删除已经处理过的map值
                map.remove(id);
            }
        }
        //当所有值都处理完毕以后，剩下的map值就是：原来有对应关系，修改后没有对应关系，删除之
        for (Map.Entry<String, SysUserPmsn> entry : map.entrySet()) {
            sysUserPmsnMapper.deleteByPrimaryKey(entry.getValue().getUpmId());
        }

        return true;
    }

    private void updUserPmsn(String userId, SysUserPmsn userPmsn, String status) {
        BaseDomain.editLog(userPmsn, userId);
        userPmsn.setStatus(status);
        sysUserPmsnMapper.updateByPrimaryKeySelective(userPmsn);
    }

    /**
     * @param userId
     * @return java.util.List<space.dyenigma.entity.SysUserPmsn>
     * @Description : 获取用户的所有直接权限映射信息
     * @author dingdongliang
     * @date 2018/2/20 19:50
     */
    @Override
    public List<SysUserPmsn> findByUserId(String userId) {
        return sysUserPmsnMapper.findAllByUserId(userId);
    }
}
