package space.dyenigma.service.impl;

import space.dyenigma.dao.GenQuestionMapper;
import space.dyenigma.entity.GenQuestion;
import space.dyenigma.service.IGenQuestionService;
import space.dyenigma.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * origin/space.dyenigma.service.impl
 *
 * @Description:
 * @Author: dingdongliang
 * @Date: 2017/07/21
 */
@Service
@Transactional
public class GenQuestionService extends BaseService<GenQuestion> implements
        IGenQuestionService {
    @Autowired
    private GenQuestionMapper genQuestionMapper;

    /**
     * @param pageUtil
     * @return java.util.List<space.dyenigma.entity.GenQuestion>
     * @Description : 分页查询所有信息
     * @author dingdongliang
     * @date 2018/2/20 19:45
     */
    @Override
    public List<GenQuestion> findAllByPage(PageUtil pageUtil) {
        return genQuestionMapper.findAllByPage(pageUtil);
    }

    /**
     * @param userId
     * @return java.util.List<space.dyenigma.entity.GenQuestion>
     * @Description : 查找某个用户的所有问题
     * @author dingdongliang
     * @date 2018/2/20 19:45
     */
    @Override
    public List<GenQuestion> findAllByUser(String userId) {
        return null;
    }

    /**
     * @param start
     * @param end
     * @return java.util.List<space.dyenigma.entity.GenQuestion>
     * @Description : 查找某段时间内的所有问题
     * @author dingdongliang
     * @date 2018/2/20 19:45
     */
    @Override
    public List<GenQuestion> findAllByTime(String start, String end) {
        return null;
    }

    /**
     * @param key
     * @return java.util.List<space.dyenigma.entity.GenQuestion>
     * @Description : 按关键字列查询问题
     * @author dingdongliang
     * @date 2018/2/20 19:45
     */
    @Override
    public List<GenQuestion> findAllByKey(String key) {
        return null;
    }

    /**
     * @param word
     * @return java.util.List<space.dyenigma.entity.GenQuestion>
     * @Description : 模糊查询
     * @author dingdongliang
     * @date 2018/2/20 19:45
     */
    @Override
    public List<GenQuestion> findAllByWord(String word) {
        return null;
    }
}
