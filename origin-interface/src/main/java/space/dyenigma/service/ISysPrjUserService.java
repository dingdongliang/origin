package space.dyenigma.service;

import space.dyenigma.entity.SysPrjUser;
import space.dyenigma.entity.SysUser;

import java.util.List;

/**
 * origin/space.dyenigma.service
 *
 * @Description: 权限类业务处理
 * @Author: dingdongliang
 * @Date: 2017/07/21
 */
public interface ISysPrjUserService extends IBaseService<SysPrjUser> {
    List<SysUser> getPrjUserByPrjId(String prjId);
}
