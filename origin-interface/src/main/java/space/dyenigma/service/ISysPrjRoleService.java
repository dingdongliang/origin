package space.dyenigma.service;

import space.dyenigma.entity.SysPrjRole;

import java.util.List;

/**
 * origin/space.dyenigma.service
 *
 * @Description:
 * @Author: dingdongliang
 * @Date: 2017/07/21
 */
public interface ISysPrjRoleService extends IBaseService<SysPrjRole> {
    List<SysPrjRole> getPrjRoleByPrjId(String prjId);
}
