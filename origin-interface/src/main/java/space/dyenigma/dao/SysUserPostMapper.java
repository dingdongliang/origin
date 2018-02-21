package space.dyenigma.dao;

import space.dyenigma.core.Mapper;
import space.dyenigma.entity.SysUserPost;

import java.util.List;

public interface SysUserPostMapper extends Mapper<SysUserPost> {
    List<SysUserPost> findByPostId(String postId);

    List<SysUserPost> findAllByUserId(String userId);
}