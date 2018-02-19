package space.dyenigma.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import space.dyenigma.common.Pagination;
import space.dyenigma.common.PaginationResult;
import space.dyenigma.common.SpecificationUtil;
import space.dyenigma.dao.FunctionDao;
import space.dyenigma.shiro.Function;
import space.dyenigma.shiro.FunctionService;

/**
 * origin/space.dyenigma.service.impl
 *
 * @Description:
 * @Author: dingdongliang
 * @Date: 2018/2/14 20:40
 */
@Service
public class FunctionServiceImpl extends EntityServiceImpl<Function, Long, FunctionDao> implements FunctionService {

    @Override
    public List<Function> findList() {

        return entityDao.findList();
    }

    @Override
    public Function findById(Integer id) {

        return entityDao.findOne(id);
    }

    @Override
    public Function findByPermissionName(String permissionName) {
        return entityDao.findByPermissionName(permissionName);
    }

    @Override
    public Function findByPid(Integer pid) {
        return entityDao.findByPid(pid);
    }

    @Override
    public List<Function> findListByPid(Integer pid) {

        return entityDao.findListByPid(pid);
    }

    @Override
    public PaginationResult<Function> findAllByPage(Pagination<Function> pagination) {

        SpecificationUtil<Function> specificationUtil = new SpecificationUtil<>();

        Map<String, Object> searchParams = new HashMap<>();

        List<String> properties = new ArrayList<>();
        properties.add("id");
        Sort sort = new Sort(Direction.DESC, properties);

        sort = pagination.dataTableOrder(pagination, sort, properties);

        String id = pagination.getExtra_search();

        searchParams.put("EQS_id", id);

        Specification<Function> specification = specificationUtil.buildSpecification(searchParams, "and");

        PageRequest PageRequest = null;

        Page<Function> list = entityDao.findAll(specification, PageRequest);

        PaginationResult<Function> pa = new PaginationResult();

        pa.setData(list.getContent());
        pa.setRecordsFiltered(list.getTotalElements());
        pa.setRecordsTotal(list.getTotalElements());
        pa.setDraw(new Integer(pagination.getDraw()));
        return pa;

    }

    @Override
    @Autowired
    public void setEntityDao(FunctionDao entityDao) {
        this.entityDao = entityDao;
    }
}
