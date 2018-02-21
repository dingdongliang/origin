package space.dyenigma.control;

import space.dyenigma.core.Result;
import space.dyenigma.core.ResultGenerator;
import space.dyenigma.entity.SysPrjRole;
import space.dyenigma.entity.SysProject;
import space.dyenigma.entity.SysUser;
import space.dyenigma.service.ISysPrjRoleService;
import space.dyenigma.service.ISysPrjUserService;
import space.dyenigma.service.ISysProjectService;
import space.dyenigma.util.Constants;
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
import org.springframework.web.bind.annotation.RequestMethod;
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
@Api(description = "编辑项目组API")
@RequestMapping(value = "/manage/project")
public class SysProjectController {

    private final Logger logger = LoggerFactory.getLogger(SysProjectController.class);

    @Resource
    private ISysProjectService sysProjectService;
    @Resource
    private ISysPrjRoleService sysPrjRoleService;
    @Resource
    private ISysPrjUserService sysPrjUserService;

    /**
     * @param
     * @return java.lang.String
     * @Description : 项目主页面跳转
     * @author dingdongliang
     * @date 2018/2/20 20:00
     */
    @RequestMapping(value = "/prjMain")
    public String prjMain() {
        logger.debug("prjMain() is executed!");
        return "manage/project/prjMain";
    }

    /**
     * @param
     * @return java.lang.String
     * @Description : 项目编辑页面跳转
     * @author dingdongliang
     * @date 2018/2/20 20:00
     */
    @RequestMapping(value = "/prjEdit")
    public String prjEdit() {
        logger.debug("prjEdit() is executed!");
        return "manage/project/prjEdit";
    }

    /**
     * @param coId
     * @return java.util.List<space.dyenigma.entity.SysProject>
     * @Description : 查询公司内项目组信息
     * @author dingdongliang
     * @date 2018/2/20 20:00
     */
    @RequestMapping(value = "/getPrjByCoId/{coId}", produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<SysProject> getPrjByCoId(@PathVariable("coId") String coId) {
        return sysProjectService.getPrjByCoId(coId);
    }

    /**
     * @param prj
     * @return space.dyenigma.core.Result
     * @Description : 项目组的新增和修改操作
     * @author dingdongliang
     * @date 2018/2/20 20:00
     */
    @ResponseBody
    @RequestMapping(value = "/saveOrUpdatePrj", produces = "application/json;charset=utf-8")
    public Result saveOrUpdatePrj(SysProject prj) {

        if (sysProjectService.persistencePrj(prj)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(Constants.POST_DATA_FAIL);
        }
    }

    /**
     * @param request
     * @return space.dyenigma.core.Result
     * @Description : 把项目组标记为过期、结束
     * @author dingdongliang
     * @date 2018/2/20 20:00
     */
    @ResponseBody
    @RequestMapping(value = "/delPrj", produces = "application/json;charset=utf-8")
    public Result delPrj(HttpServletRequest request) {
        String prjId = request.getParameter("prjId");

        if (sysProjectService.delPrj(prjId)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(Constants.IS_EXT_SUBMENU);
        }
    }

    /**
     * @param request
     * @return java.util.List<space.dyenigma.entity.SysProject>
     * @Description : 授予项目组角色
     * @author dingdongliang
     * @date 2018/2/20 20:00
     */
    @ResponseBody
    @RequestMapping(value = "/prjRole", produces = "application/json;charset=utf-8")
    public List<SysProject> prjRole(HttpServletRequest request) {
        String coId = request.getParameter("coId");
        return sysProjectService.getPrjByCoId(coId);
    }

    /**
     * @param request
     * @return space.dyenigma.core.Result
     * @Description : 项目组角色分配
     * @author dingdongliang
     * @date 2018/2/20 20:00
     */
    @ResponseBody
    @RequestMapping(value = "/savePrjRoles", produces = "application/json;charset=utf-8")
    public Result savePrjRoles(HttpServletRequest request) {
        String prjId = request.getParameter("prjId");
        String checkedIds = request.getParameter("isCheckedIds");

        if (sysProjectService.savePrjRole(prjId, checkedIds)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(Constants.POST_DATA_FAIL);
        }
    }

    /**
     * @param request
     * @return space.dyenigma.core.Result
     * @Description : 项目组角色分配
     * @author dingdongliang
     * @date 2018/2/20 20:00
     */
    @ResponseBody
    @RequestMapping(value = "/savePrjUsers", produces = "application/json;charset=utf-8")
    public Result savePrjUsers(HttpServletRequest request) {
        String prjId = request.getParameter("prjId");
        String checkedIds = request.getParameter("isCheckedIds");

        if (sysProjectService.savePrjUsers(prjId, checkedIds)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(Constants.POST_DATA_FAIL);
        }

    }

    @ResponseBody
    @RequestMapping(value = "/searchPrjUser", produces = "application/json;charset=utf-8")
    public List<SysUser> searchPrjUser(HttpServletRequest request) {
        String prjId = request.getParameter("prjId");
        return sysProjectService.searchPrjUser(prjId);
    }

    /**
     * @param
     * @return java.lang.String
     * @Description :
     * @author dingdongliang
     * @date 2018/2/20 20:01
     */
    @RequestMapping(value = "/toSetRole", method = RequestMethod.GET)
    public String toSetRole() {

        logger.debug("toSetRole() is executed!");

        return "manage/project/prjRole";
    }

    /**
     * @param
     * @return java.lang.String
     * @Description :
     * @author dingdongliang
     * @date 2018/2/20 20:01
     */
    @RequestMapping(value = "/toUserList", method = RequestMethod.GET)
    public String toUserList() {

        logger.debug("toUserList() is executed!");

        return "manage/project/prjUser";
    }

    @ResponseBody
    @RequestMapping(value = "/getPrjRoleByPrjId", produces = "application/json;charset=utf-8")
    public List<SysPrjRole> getPrjRoleByPrjId(HttpServletRequest request) {
        String prjId = request.getParameter("prjId");
        return sysPrjRoleService.getPrjRoleByPrjId(prjId);
    }

    @ResponseBody
    @RequestMapping(value = "/getPrjUserByPrjId", produces = "application/json;charset=utf-8")
    public List<SysUser> getPrjUserByPrjId(HttpServletRequest request) {
        String prjId = request.getParameter("prjId");
        return sysPrjUserService.getPrjUserByPrjId(prjId);
    }

    @ResponseBody
    @PostMapping
    public Result add(SysProject sysProject) {
        sysProjectService.save(sysProject);
        return ResultGenerator.genSuccessResult();
    }

    @ResponseBody
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        sysProjectService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @ResponseBody
    @PutMapping
    public Result update(SysProject sysProject) {
        sysProjectService.update(sysProject);
        return ResultGenerator.genSuccessResult();
    }

    @ResponseBody
    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        SysProject sysProject = sysProjectService.findById(id);
        return ResultGenerator.genSuccessResult(sysProject);
    }

    @ResponseBody
    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SysProject> list = sysProjectService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
