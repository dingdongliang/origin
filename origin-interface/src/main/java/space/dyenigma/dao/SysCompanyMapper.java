package space.dyenigma.dao;

import space.dyenigma.core.Mapper;
import space.dyenigma.entity.SysCompany;
import space.dyenigma.util.PageUtil;

import java.util.List;

public interface SysCompanyMapper extends Mapper<SysCompany> {
    /**
     * @param pageUtil
     * @return java.util.List<space.dyenigma.entity.SysCompany>
     * @Description : 分页查询公司信息
     * @author dingdongliang
     * @date 2018/2/20 19:08
     */
    List<SysCompany> findAllByPage(PageUtil pageUtil);

    /**
     * @param prntId
     * @return java.util.List<space.dyenigma.entity.SysCompany>
     * @Description :  根据父ID查询公司信息
     * @author dingdongliang
     * @date 2018/2/20 19:09
     */
    List<SysCompany> selectByPrntId(String prntId);

    List<SysCompany> findByPid(String pid);
}