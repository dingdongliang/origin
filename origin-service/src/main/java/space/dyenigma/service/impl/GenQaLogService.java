package space.dyenigma.service.impl;

import space.dyenigma.dao.GenQaLogMapper;
import space.dyenigma.entity.GenQaLog;
import space.dyenigma.service.IGenQaLogService;
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
public class GenQaLogService extends BaseService<GenQaLog> implements
        IGenQaLogService {
    @Resource
    private GenQaLogMapper genQaLogMapper;

}
