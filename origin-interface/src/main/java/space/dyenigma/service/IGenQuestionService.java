package space.dyenigma.service;

import space.dyenigma.entity.GenQuestion;
import space.dyenigma.util.PageUtil;

import java.util.List;

/**
 * origin/space.dyenigma.service
 *
 * @Description:
 * @Author: dingdongliang
 * @Date: 2017/07/21
 */
public interface IGenQuestionService extends IBaseService<GenQuestion> {
    /**
     * @param pageUtil
     * @return java.util.List<space.dyenigma.entity.GenQuestion>
     * @Description : 分页查询所有信息
     * @author dingdongliang
     * @date 2018/2/20 19:16
     */
    List<GenQuestion> findAllByPage(PageUtil pageUtil);

    /**
     * @param userId
     * @return java.util.List<space.dyenigma.entity.GenQuestion>
     * @Description : 查找某个用户的所有问题
     * @author dingdongliang
     * @date 2018/2/20 19:16
     */
    List<GenQuestion> findAllByUser(String userId);

    /**
     * @param start
     * @param end
     * @return java.util.List<space.dyenigma.entity.GenQuestion>
     * @Description : 查找某段时间内的所有问题
     * @author dingdongliang
     * @date 2018/2/20 19:16
     */
    List<GenQuestion> findAllByTime(String start, String end);

    /**
     * @param key
     * @return java.util.List<space.dyenigma.entity.GenQuestion>
     * @Description : 按关键字列查询问题
     * @author dingdongliang
     * @date 2018/2/20 19:16
     */
    List<GenQuestion> findAllByKey(String key);

    /**
     * @param word
     * @return java.util.List<space.dyenigma.entity.GenQuestion>
     * @Description : 模糊查询
     * @author dingdongliang
     * @date 2018/2/20 19:16
     */
    List<GenQuestion> findAllByWord(String word);
}
