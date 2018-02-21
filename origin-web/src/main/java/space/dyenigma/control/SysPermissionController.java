package space.dyenigma.control;

import space.dyenigma.core.Result;
import space.dyenigma.core.ResultGenerator;
import space.dyenigma.entity.SysPermission;
import space.dyenigma.model.MultiMenu;
import space.dyenigma.model.TreeModel;
import space.dyenigma.service.ISysPermissionService;
import space.dyenigma.util.Constants;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
@Api(description = "权限管理API")
@RequestMapping(value = "/manage/menu")
public class SysPermissionController {

    private final Logger logger = LoggerFactory.getLogger(SysPermissionController.class);

    @Resource
    private ISysPermissionService sysPermissionService;

    /**
     * @param
     * @return java.lang.String
     * @Description : 打开操作菜单页面
     * @author dingdongliang
     * @date 2018/2/20 19:58
     */
    @GetMapping("/menuMain")
    public String main() {

        logger.debug("main() is executed!");

        return "manage/permission/pmsnMain";
    }

    /**
     * @param request
     * @return java.util.List<space.dyenigma.entity.SysPermission>
     * @Description : 显示所有可操作的菜单项，用于菜单编辑页面
     * @author dingdongliang
     * @date 2018/2/20 19:58
     */
    @ResponseBody
    @RequestMapping(value = "/findAllMenuList", produces = "application/json;charset=utf-8")
    public List<SysPermission> findAllMenuList(HttpServletRequest request) {
        String pmsnId = request.getParameter("id");
        return sysPermissionService.findByPid(pmsnId);
    }

    /**
     * @param
     * @return java.util.List<space.dyenigma.model.MultiMenu>
     * @Description : 用于角色权限菜单分配
     * @author dingdongliang
     * @date 2018/2/20 19:58
     */
    @ResponseBody
    @RequestMapping(value = "/findAllRoleMenu", produces = "application/json;charset=utf-8")
    public List<MultiMenu> findAllRoleMenu() {
        return sysPermissionService.multiMenu();
    }

    /**
     * @param
     * @return java.util.List<space.dyenigma.model.TreeModel>
     * @Description : 显示所有可添加子项的菜单项
     * @author dingdongliang
     * @date 2018/2/20 19:58
     */
    @ResponseBody
    @GetMapping(value = "/findSuperMenu", produces = "application/json;charset=utf-8")
    public List<TreeModel> findSuperFunc() {
        return sysPermissionService.findSuperFunc();
    }

    /**
     * @param request
     * @return space.dyenigma.core.Result
     * @Description : 删除菜单处理
     * @author dingdongliang
     * @date 2018/2/20 19:58
     */
    @ResponseBody
    @PostMapping(value = "/delMenu", produces = "application/json;charset=utf-8")
    public Result delFunction(HttpServletRequest request) {
        String id = request.getParameter("id");

        if (sysPermissionService.deleteById(id)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(Constants.IS_EXT_SUBMENU);
        }
    }

    /**
     * @param
     * @return java.lang.String
     * @Description : 跳转到编辑菜单页面
     * @author dingdongliang
     * @date 2018/2/20 19:58
     */
    @RequestMapping(value = "/menuEditDlg", method = RequestMethod.GET)
    public String functionEditDlg() {
        logger.debug("functionEditDlg() is executed!");
        return "manage/permission/pmsnEdit";
    }

    /**
     * @param permission
     * @return space.dyenigma.core.Result
     * @Description : 新增菜单或者更新菜单处理
     * @author dingdongliang
     * @date 2018/2/20 19:59
     */
    @RequiresPermissions({"menuAdd", "menuEdit"})
    @ResponseBody
    @RequestMapping(value = "/saveOrUpdateMenu", produces = "application/json;charset=utf-8")
    public Result saveOrUpdateFunc(SysPermission permission) {

        if (sysPermissionService.persistenceFunction(permission)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(Constants.POST_DATA_FAIL);
        }
    }

    @ResponseBody
    @PostMapping
    public Result add(SysPermission sysPermission) {
        sysPermissionService.save(sysPermission);
        return ResultGenerator.genSuccessResult();
    }

    @ResponseBody
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        sysPermissionService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @ResponseBody
    @PutMapping
    public Result update(SysPermission sysPermission) {
        sysPermissionService.update(sysPermission);
        return ResultGenerator.genSuccessResult();
    }

    @ResponseBody
    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        SysPermission sysPermission = sysPermissionService.findById(id);
        return ResultGenerator.genSuccessResult(sysPermission);
    }

    @ResponseBody
    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SysPermission> list = sysPermissionService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
