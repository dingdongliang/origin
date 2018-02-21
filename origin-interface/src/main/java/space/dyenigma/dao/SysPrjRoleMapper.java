package space.dyenigma.dao;

import space.dyenigma.core.Mapper;
import space.dyenigma.entity.SysPrjRole;

import java.util.List;

public interface SysPrjRoleMapper extends Mapper<SysPrjRole> {
    List<SysPrjRole> findAllByPrjId(String prjId);

    List<SysPrjRole> findAllByRoleId(String roleId);
}