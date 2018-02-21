package space.dyenigma.service.impl;

import space.dyenigma.dao.SysPrjRoleMapper;
import space.dyenigma.entity.SysPrjRole;
import space.dyenigma.service.ISysPrjRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class SysPrjRoleService extends BaseService<SysPrjRole> implements
        ISysPrjRoleService {

    @Autowired
    private SysPrjRoleMapper sysPrjRoleMapper;

    @Override
    public List<SysPrjRole> getPrjRoleByPrjId(String prjId) {
        return sysPrjRoleMapper.findAllByPrjId(prjId);
    }

}
