package space.dyenigma.control;

import space.dyenigma.core.Result;
import space.dyenigma.core.ResultGenerator;
import space.dyenigma.entity.GenQuestion;
import space.dyenigma.model.GridModel;
import space.dyenigma.service.IGenQuestionService;
import space.dyenigma.util.PageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * origin/space.dyenigma.control
 *
 * @Description:
 * @Author: dingdongliang
 * @Date: 2017/7/21
 */
@Controller
@Api(description = "问题操作API")
@RequestMapping(value = "/manage/qstn")
public class GenQuestionController {
    private final Logger logger = LoggerFactory.getLogger(GenQuestionController.class);

    @Resource
    private IGenQuestionService genQuestionService;

    /**
     * param return 参数
     * return String 返回类型
     * throws
     * Title: main
     * Description: 打开操作菜单页面
     */
    @GetMapping("/qaList")
    public String qaList() {

        logger.debug("qaList() is executed!");

        return "manage/research/qaList";
    }

    @ResponseBody
    @GetMapping(value = "/findAllByPage", produces = "application/json;charset=utf-8")
    public GridModel findAllByPage(HttpServletRequest request) {
        logger.debug("findAllByPage() is executed!");
        int pageNo = Integer.parseInt(request.getParameter("page"));
        int length = Integer.parseInt(request.getParameter("rows"));
        PageUtil pageUtil = new PageUtil((pageNo - 1) * length, length);
        GridModel gridModel = new GridModel();
        gridModel.setRows(genQuestionService.findAllByPage(pageUtil));
        gridModel.setTotal(genQuestionService.getCount(null));
        return gridModel;
    }

    @PostMapping
    @ResponseBody
    public Result add(GenQuestion genQuestion) {
        genQuestionService.save(genQuestion);
        return ResultGenerator.genSuccessResult();
    }

    @ResponseBody
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        genQuestionService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    @ResponseBody
    public Result update(GenQuestion genQuestion) {
        genQuestionService.update(genQuestion);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Result detail(@PathVariable Integer id) {
        GenQuestion genQuestion = genQuestionService.findById(id);
        return ResultGenerator.genSuccessResult(genQuestion);
    }

    @GetMapping("/list")
    @ResponseBody
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<GenQuestion> list = genQuestionService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
