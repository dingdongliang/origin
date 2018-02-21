package space.dyenigma.service;

import org.apache.ibatis.exceptions.TooManyResultsException;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;
import java.util.Map;

/**
 * origin/space.dyenigma.service
 *
 * @Description:
 * @Author: dingdongliang
 * @Date: 2017/7/14 11:56
 */
public interface IBaseService<T> {

    void save(T model);

    void save(List<T> models);

    void deleteById(Integer id);

    /**
     * @param ids likes “1,2,3,4”
     * @return void
     * @Description : 批量刪除
     * @author dingdongliang
     * @date 2018/2/20 19:14
     */
    void deleteByIds(String ids);

    void update(T model);

    T findById(Integer id);

    /**
     * @param fieldName
     * @param value     需符合unique约束
     * @return T
     * @Description : 通过Model中某个成员变量名称（非数据表中column的名称）查找
     * @author dingdongliang
     * @date 2018/2/20 19:14
     * throws TooManyResultsException
     */
    T findBy(String fieldName, Object value) throws TooManyResultsException;

    /**
     * @param ids likes “1,2,3,4”
     * @return java.util.List<T>
     * @Description : 通过多个ID查找符合条件的集合
     * @author dingdongliang
     * @date 2018/2/20 19:15
     */
    List<T> findByIds(String ids);

    /**
     * @param condition 查询条件
     * @return java.util.List<T>
     * @Description : 根据条件查找
     * @author dingdongliang
     * @date 2018/2/20 19:15
     */
    List<T> findByCondition(Condition condition);

    List<T> findAll();

    /**
     * @param paramMap
     * @return java.lang.Integer
     * @Description : 获取某个查询的结果条数
     * @author dingdongliang
     * @date 2018/2/20 19:15
     */
    Integer getCount(Map<String, Object> paramMap);

}
