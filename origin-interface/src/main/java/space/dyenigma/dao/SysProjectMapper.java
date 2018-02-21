package space.dyenigma.dao;

import space.dyenigma.core.Mapper;
import space.dyenigma.entity.SysProject;

import java.util.List;

public interface SysProjectMapper extends Mapper<SysProject> {
    List<SysProject> getPrjByCoId(String coId);
}