package space.dyenigma.dao;

import space.dyenigma.core.Mapper;
import space.dyenigma.entity.SysDivision;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysDivisionMapper extends Mapper<SysDivision> {
    /**
     * @param id
     * @return int
     * @Description : 更新组织信息为过期
     * @author dingdongliang
     * @date 2018/2/20 19:09
     */
    int updateById(String id);

    /**
     * @param coId
     * @return java.util.List<space.dyenigma.entity.SysDivision>
     * @Description : 获取所有可添加子项的组织信息
     * @author dingdongliang
     * @date 2018/2/20 19:09
     */
    List<SysDivision> findSuperOrgan(String coId);

    /**
     * @param coId
     * @return java.util.List<space.dyenigma.entity.SysDivision>
     * @Description : 查找某个公司下面的所有组织信息
     * @author dingdongliang
     * @date 2018/2/20 19:09
     */
    List<SysDivision> findByCompId(@Param("coId") String coId);
}