package space.dyenigma.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import space.dyenigma.shiro.Function;

/**
 * origin/space.dyenigma.dao
 *
 * @Description:
 * @Author: dingdongliang
 * @Date: 2018/2/14 20:35
 */
@Transactional
@Service
public interface FunctionDao extends BaseDao<Function, Long> {

    @Query("from Function")
    List<Function> findList();

    Function findByPermissionName(String permissionName);

    Function findByPid(Integer pid);

    @Query("from Function where pid=?")
    List<Function> findListByPid(Integer pid);
}
