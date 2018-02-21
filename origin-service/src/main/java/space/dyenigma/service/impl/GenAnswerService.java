package space.dyenigma.service.impl;

import space.dyenigma.dao.GenAnswerMapper;
import space.dyenigma.entity.GenAnswer;
import space.dyenigma.service.IGenAnswerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * origin/space.dyenigma.service.impl
 *
 * @Description:
 * @Author: dingdongliang
 * @Date: 2017/07/21
 */
@Service
@Transactional
public class GenAnswerService extends BaseService<GenAnswer> implements
        IGenAnswerService {
    @Resource
    private GenAnswerMapper genAnswerMapper;

}
