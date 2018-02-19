package space.dyenigma.common;

import java.util.Map;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import space.dyenigma.util.ReflectionUtils;
import space.dyenigma.util.SearchFilter;

/**
 * origin/space.dyenigma.common
 *
 * @Description:
 * @Author: dingdongliang
 * @Date: 2018/2/14 18:59
 */
public class SpecificationUtil<T> {

    protected Class<T> entityClass;

    public SpecificationUtil() {
        this.entityClass = ReflectionUtils.getSuperClassGenricType(getClass());
    }

    /**
     * 创建分页请求.
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
     * 创建动态查询条件组合.
     */
    public Specification<T> buildSpecification(Map<String, Object> searchParams, String orAnd) {
        Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
        Specification<T> spec = null;
        if (orAnd.equals("or")) {
            spec = DynamicSpecifications.bySearchFilterOr(filters.values(), ReflectionUtils.getSuperClassGenricType(getClass()));
        } else {
            spec = DynamicSpecifications.bySearchFilter(filters.values(), ReflectionUtils.getSuperClassGenricType(getClass()));
        }

        return spec;
    }

}