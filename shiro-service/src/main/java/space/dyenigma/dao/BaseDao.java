package space.dyenigma.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * origin/space.dyenigma.dao
 *
 * @Description:
 * @Author: dingdongliang
 * @Date: 2018/2/14 20:30
 */
@NoRepositoryBean
public interface BaseDao<T, pk extends Serializable> extends PagingAndSortingRepository<T, Serializable>,
        JpaSpecificationExecutor<T> {
}
