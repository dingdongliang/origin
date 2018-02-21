package space.dyenigma.dao;

import space.dyenigma.core.Mapper;
import space.dyenigma.entity.SysUserPmsn;

import java.util.List;

public interface SysUserPmsnMapper extends Mapper<SysUserPmsn> {
    List<SysUserPmsn> findAllByUserId(String userId);

    int delByPmsnId(String pmsnId);

    int delByUserId(String userId);
}