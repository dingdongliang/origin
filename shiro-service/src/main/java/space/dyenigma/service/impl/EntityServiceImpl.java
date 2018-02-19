package space.dyenigma.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;

import space.dyenigma.common.DynamicSpecifications;
import space.dyenigma.dao.BaseDao;
import space.dyenigma.service.EntityService;
import space.dyenigma.util.ReflectionUtils;
import space.dyenigma.util.SearchFilter;

/**
 * origin/space.dyenigma.service.impl
 *
 * @Description: 所有业务查询实现类的基类
 * @Author: dingdongliang
 * @Date: 2018/2/14 20:39
 */
public abstract class EntityServiceImpl<T, PK extends Serializable, EntityDao extends BaseDao<T, PK>> implements
        EntityService<T, PK> {

    protected Class<T> entityClass;

    protected EntityDao entityDao;

    @Override
    public T get(PK id) {

        return entityDao.findOne(id);
    }

    @Override
    public void delete(PK id) {
        entityDao.delete(id);
    }

    public void delete(T entity) {
        entityDao.delete(entity);
    }

    @Override
    public void save(T t) {
        entityDao.save(t);
    }

    @Override
    public Iterable<T> getAll() {

        return entityDao.findAll();
    }

    public EntityServiceImpl() {
        this.entityClass = ReflectionUtils.getSuperClassGenricType(getClass());
    }


    /**
     * @param pageNumber
     * @param pagzSize
     * @param sortType
     * @return org.springframework.data.domain.PageRequest
     * @Description : 创建分页请求.
     * @author dingdongliang
     * @date 2018/2/15 8:38
     */
    protected PageRequest buildPageRequest(int pageNumber, int pagzSize, String sortType) {
        Sort sort = null;
        if ("auto".equals(sortType)) {
            sort = new Sort(Direction.ASC, "id");
        } else if (sortType != null && !"".equals(sortType) && !sortType.contains("_ASC")) {
            sort = new Sort(Direction.DESC, sortType);
        } else if (null != sortType && sortType.contains("_ASC")) {
            sort = new Sort(Direction.ASC, sortType.split("_ASC")[0]);
        }
        return new PageRequest(pageNumber - 1, pagzSize, sort);
    }


    /**
     * @param searchParams
     * @return org.springframework.data.jpa.domain.Specification<T>
     * @Description : 创建动态查询条件组合.
     * @author dingdongliang
     * @date 2018/2/15 8:38
     */
    protected Specification<T> buildSpecification(Map<String, Object> searchParams) {
        Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
        Specification<T> spec = DynamicSpecifications.bySearchFilter(filters.values(), entityClass);
        return spec;
    }

    @Override
    public Page<T> search(Map<String, Object> searchParams, int pageNumber, int pageSize, String sortType) {
        PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
        if (searchParams != null) {
            Specification<T> spec = buildSpecification(searchParams);
            return entityDao.findAll(spec, pageRequest);
        }
        return entityDao.findAll(pageRequest);
    }

    @Override
    public List<T> findAll(Map<String, Object> searchParams, Sort sort) {
        return entityDao.findAll(buildSpecification(searchParams), sort);
    }

    @Override
    public List<T> findAll(Map<String, Object> searchParams) {

        return entityDao.findAll(buildSpecification(searchParams));
    }

    public abstract void setEntityDao(EntityDao entityDao);

    @Override
    public void delete(Iterable<T> entities) {
        entityDao.delete(entities);
    }

}
