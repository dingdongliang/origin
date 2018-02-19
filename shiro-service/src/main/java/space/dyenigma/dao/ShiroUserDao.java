package space.dyenigma.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import space.dyenigma.shiro.ShiroUser;

/**
 * origin/space.dyenigma.dao
 *
 * @Description:
 * @Author: dingdongliang
 * @Date: 2018/2/14 20:38
 */
@Service
public interface ShiroUserDao extends BaseDao<ShiroUser, Long> {
    ShiroUser findByUsername(String userName);

    @Query(value = "select j from ShiroUser j where j.username = :username ")
    ShiroUser findByUsernameForUpdate(@Param("username") String username);

    // 动态sql分页查询
    Page<ShiroUser> findAll(Specification<ShiroUser> spec, Pageable pageable);
}