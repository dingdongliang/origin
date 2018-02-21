package space.dyenigma.control;

import space.dyenigma.core.Result;
import space.dyenigma.core.ResultGenerator;
import space.dyenigma.entity.SysUserPost;
import space.dyenigma.service.ISysUserPostService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
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
@Api(description = "用户岗位分配API")
@RequestMapping("/sys/user/post")
public class SysUserPostController {

    private final Logger logger = LoggerFactory.getLogger(SysUserPostController.class);

    @Resource
    private ISysUserPostService sysUserPostService;

    @PostMapping
    public Result add(SysUserPost sysUserPost) {
        sysUserPostService.save(sysUserPost);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        sysUserPostService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(SysUserPost sysUserPost) {
        sysUserPostService.update(sysUserPost);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        SysUserPost sysUserPost = sysUserPostService.findById(id);
        return ResultGenerator.genSuccessResult(sysUserPost);
    }

    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SysUserPost> list = sysUserPostService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
