package space.dyenigma.control;

import space.dyenigma.core.Result;
import space.dyenigma.core.ResultGenerator;
import space.dyenigma.entity.GenFrontMenu;
import space.dyenigma.service.IGenFrontMenuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.List;

/**
 * origin/space.dyenigma.control
 *
 * @Description:
 * @Author: dingdongliang
 * @Date: 2017/7/21
 */
@RestController
@ApiIgnore
@RequestMapping("/gen/front/menu")
public class GenFrontMenuController {

    private final Logger logger = LoggerFactory.getLogger(GenFrontMenuController.class);
    @Resource
    private IGenFrontMenuService genFrontMenuService;

    @PostMapping
    public Result add(GenFrontMenu genFrontMenu) {
        genFrontMenuService.save(genFrontMenu);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        genFrontMenuService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(GenFrontMenu genFrontMenu) {
        genFrontMenuService.update(genFrontMenu);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        GenFrontMenu genFrontMenu = genFrontMenuService.findById(id);
        return ResultGenerator.genSuccessResult(genFrontMenu);
    }

    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<GenFrontMenu> list = genFrontMenuService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
