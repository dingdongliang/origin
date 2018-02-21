package space.dyenigma.service.impl;

import space.dyenigma.dao.SysDivisionMapper;
import space.dyenigma.dao.SysPostMapper;
import space.dyenigma.entity.BaseDomain;
import space.dyenigma.entity.SysDivision;
import space.dyenigma.entity.SysPost;
import space.dyenigma.model.TreeModel;
import space.dyenigma.service.ISysDivisionService;
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
 * @Date: 2016/4/2 18:47
 */
@Service
@Transactional
public class SysDivisionService extends BaseService<SysDivision> implements
        ISysDivisionService {

    @Autowired
    private SysPostMapper sysPostMapper;
    @Autowired
    private SysDivisionMapper sysDivisionMapper;

    @Override
    public boolean deleteById(String id) {
        //如果部门下面有岗位，不能删除
        List<SysPost> pList = sysPostMapper.findPostByDiv(id);
        if (pList.size() > 0) {
            return false;
        } else {
            SysDivision divi = sysDivisionMapper.selectByPrimaryKey(id);
            divi.setStatus(Constants.PERSISTENCE_DELETE_STATUS);
            return sysDivisionMapper.updateByPrimaryKey(divi) > 0;
        }
    }

    @Override
    public List<TreeModel> findSuperOrgan(String id) {
        List<SysDivision> organList = sysDivisionMapper.findSuperOrgan(id);
        List<TreeModel> tList = new ArrayList<>();
        for (SysDivision divi : organList) {
            TreeModel treeModel = new TreeModel();
            treeModel.setId(divi.getDivId());
            treeModel.setPid("");
            treeModel.setText(divi.getDivName()); //注意部门管理修改为combotree形式
            treeModel.setIconCls(divi.getIconCls());
            treeModel.setState(Constants.TREE_STATUS_OPEN);
            tList.add(treeModel);
        }

        return tList;
    }

    @Override
    public boolean persistenceOrgan(SysDivision divi) {
        String userId = Constants.getCurrendUser().getUserId();

        if (StringUtil.isEmpty(divi.getDivId())) {

            BaseDomain.createLog(divi, userId);
            divi.setStatus(Constants.PERSISTENCE_STATUS);
            // 部门下级不允许有子部门
            divi.setState(Constants.TREE_STATUS_OPEN);
            divi.setDivId(UUIDUtil.getUUID());
            divi.setIconCls(Constants.DIVISION_ICON);
            sysDivisionMapper.insert(divi);
        } else {
            divi.setState(Constants.TREE_STATUS_OPEN);
            BaseDomain.editLog(divi, userId);
            divi.setIconCls(Constants.DIVISION_ICON);
            sysDivisionMapper.updateByPrimaryKeySelective(divi);
        }
        return true;
    }

    /**
     * @param id
     * @return java.util.List<space.dyenigma.entity.SysDivision>
     * @Description : 根据公司ID查询部门信息
     * @author dingdongliang
     * @date 2018/2/20 19:46
     */
    @Override
    public List<SysDivision> findDivByCoId(String id) {
        return sysDivisionMapper.findByCompId(id);
    }
}
