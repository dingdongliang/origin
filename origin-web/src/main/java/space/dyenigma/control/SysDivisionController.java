package space.dyenigma.control;

import space.dyenigma.core.Result;
import space.dyenigma.core.ResultGenerator;
import space.dyenigma.entity.SysDivision;
import space.dyenigma.model.TreeModel;
import space.dyenigma.service.ISysDivisionService;
import space.dyenigma.util.Constants;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
@Api(description = "组织管理API")
@RequestMapping(value = "/manage/organ")
public class SysDivisionController {

    private final Logger logger = LoggerFactory.getLogger(SysDivisionController.class);

    @Autowired
    private ISysDivisionService sysDivisionService;

    @RequestMapping("/organMain")
    public String main() {
        logger.debug("main() is executed!");
        return "manage/division/divMain";
    }

    @ResponseBody
    @RequestMapping(value = "/findDivByCoId/{coId}", produces = "application/json;charset=utf-8")
    public List<SysDivision> findDivByCoId(@PathVariable("coId") String coId) {
        return sysDivisionService.findDivByCoId(coId);
    }

    /**
     * @param companyId
     * @param model
     * @return java.lang.String
     * @Description : 跳转到编辑组织页面
     * @author dingdongliang
     * @date 2018/2/20 19:58
     */
    @RequestMapping(value = "/organEditDlg/{coId}", method = RequestMethod.GET)
    public String organEditDlg(@PathVariable("coId") String companyId, Model model) {

        logger.debug("organEditDlg() is executed!");

        model.addAttribute("coId", companyId);

        return "manage/division/divEdit";
    }

    /**
     * @param request
     * @return space.dyenigma.core.Result
     * @Description : 删除组织处理
     * @author dingdongliang
     * @date 2018/2/20 19:58
     */
    @ResponseBody
    @RequestMapping(value = "/delOrgan", produces = "application/json;charset=utf-8")
    public Result delOrgan(HttpServletRequest request) {
        String id = request.getParameter("id");

        if (sysDivisionService.deleteById(id)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(Constants.IS_EXT_SUBMENU);
        }

    }

    /**
     * @param companyId
     * @return java.util.List<space.dyenigma.model.TreeModel>
     * @Description : 显示所有可添加子项的组织项
     * @author dingdongliang
     * @date 2018/2/20 19:58
     */
    @ResponseBody
    @RequestMapping(value = "/findSuperOrgan/{coId}", produces = "application/json;charset=utf-8")
    public List<TreeModel> findSuperOrgan(@PathVariable("coId") String companyId) {

        return sysDivisionService.findSuperOrgan(companyId);

    }

    /**
     * @param division
     * @return space.dyenigma.core.Result
     * @Description : 新增组织从或者更新组织处理
     * @author dingdongliang
     * @date 2018/2/20 19:58
     */
    @ResponseBody
    @RequestMapping(value = "/saveOrUpdateOrgan", produces = "application/json;charset=utf-8")
    public Result saveOrUpdateOrgan(SysDivision division) {
        if (sysDivisionService.persistenceOrgan(division)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(Constants.POST_DATA_FAIL);
        }
    }

    @PostMapping
    @ResponseBody
    public Result add(SysDivision sysDivision) {
        sysDivisionService.save(sysDivision);
        return ResultGenerator.genSuccessResult();
    }

    @ResponseBody
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        sysDivisionService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @ResponseBody
    @PutMapping
    public Result update(SysDivision sysDivision) {
        sysDivisionService.update(sysDivision);
        return ResultGenerator.genSuccessResult();
    }

    @ResponseBody
    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        SysDivision sysDivision = sysDivisionService.findById(id);
        return ResultGenerator.genSuccessResult(sysDivision);
    }

    @ResponseBody
    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SysDivision> list = sysDivisionService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
