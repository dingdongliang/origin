package space.dyenigma.service.impl;

import space.dyenigma.dao.GenFrontMenuMapper;
import space.dyenigma.entity.GenFrontMenu;
import space.dyenigma.service.IGenFrontMenuService;
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
public class GenFrontMenuService extends BaseService<GenFrontMenu> implements
        IGenFrontMenuService {
    @Resource
    private GenFrontMenuMapper genFrontMenuMapper;

}
