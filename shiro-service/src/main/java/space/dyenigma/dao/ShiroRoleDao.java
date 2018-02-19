package space.dyenigma.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import space.dyenigma.shiro.ShiroRole;

/**
 * origin/space.dyenigma.dao
 *
 * @Description:
 * @Author: dingdongliang
 * @Date: 2018/2/14 20:37
 */
@Transactional
@Service
public interface ShiroRoleDao extends BaseDao<ShiroRole, Long> {

    @Query("from ShiroRole")
    List<ShiroRole> findRoleList();

    ShiroRole findByRoleName(String roleName);

}
