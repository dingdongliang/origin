package space.dyenigma.dao;

import space.dyenigma.core.Mapper;
import space.dyenigma.entity.SysPostRole;

import java.util.List;

public interface SysPostRoleMapper extends Mapper<SysPostRole> {
    List<SysPostRole> findAllByPostId(String postId);

    List<SysPostRole> findAllByRoleId(String roleId);
}