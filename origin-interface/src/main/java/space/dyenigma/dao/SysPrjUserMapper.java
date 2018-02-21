package space.dyenigma.dao;

import space.dyenigma.core.Mapper;
import space.dyenigma.entity.SysPrjUser;

import java.util.List;

public interface SysPrjUserMapper extends Mapper<SysPrjUser> {
    List<SysPrjUser> getPrjUserByPrjId(String prjId);

    List<SysPrjUser> findAllByUserId(String userId);
}