package space.dyenigma.control;

import space.dyenigma.core.Result;
import space.dyenigma.core.ResultGenerator;
import space.dyenigma.entity.SysPermission;
import space.dyenigma.entity.SysRole;
import space.dyenigma.model.GridModel;
import space.dyenigma.service.ISysRolePmsnService;
import space.dyenigma.service.ISysRoleService;
import space.dyenigma.util.Constants;
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
@Api(description = "编辑权限API")
@RequestMapping(value = "/manage/role")
public class SysRoleController {

    private final Logger logger = LoggerFactory.getLogger(SysRoleController.class);
    @Resource
    private ISysRoleService sysRoleService;
    @Resource
    private ISysRolePmsnService sysRolePmsnService;

    /**
     * @param
     * @return java.lang.String
     * @Description : 跳转到主页面
     * @author dingdongliang
     * @date 2018/2/20 20:01
     */
    @RequestMapping("/roleMgr")
    public String roleMain() {
        logger.debug("roleMain() is executed!");
        return "manage/role/roleMain";
    }

    /**
     * @param request
     * @return space.dyenigma.model.GridModel
     * @Description : 搜索所有的角色信息，分页
     * @author dingdongliang
     * @date 2018/2/20 20:01
     */
    @ResponseBody
    @RequestMapping(value = "/allRoleByPage", produces = "application/json;charset=utf-8")
    public GridModel allRoleByPage(HttpServletRequest request) {
        logger.debug("allRoleByPage() is executed!");
        int pageNo = Integer.parseInt(request.getParameter("page"));
        int length = Integer.parseInt(request.getParameter("rows"));
        PageUtil pageUtil = new PageUtil((pageNo - 1) * length, length);
        GridModel gridModel = new GridModel();
        gridModel.setRows(sysRoleService.findAllRoleList(pageUtil));
        gridModel.setTotal(sysRoleService.getCount(null));
        return gridModel;
    }

    /**
     * @param
     * @return java.util.List<space.dyenigma.entity.SysRole>
     * @Description : 查询所有角色
     * @author dingdongliang
     * @date 2018/2/20 20:01
     */
    @ResponseBody
    @RequestMapping(value = "/findAllRoleList", produces = "application/json;charset=utf-8")
    public List<SysRole> findAllRoleList() {
        logger.debug("findAllRoleList() is executed!");
        return sysRoleService.findAll();
    }

    /**
     * @param
     * @return java.lang.String
     * @Description : 跳转到添加和编辑子页面
     * @author dingdongliang
     * @date 2018/2/20 20:01
     */
    @RequestMapping("/roleEditDlg")
    public String roleEditDlg() {
        logger.debug("roleEditDlg() is executed!");
        return "manage/role/roleEdit";
    }

    /**
     * @param role
     * @return space.dyenigma.core.Result
     * @Description : 持久化角色对象，提交到业务处理层后根据roleId来判断是新增还是编辑
     * @author dingdongliang
     * @date 2018/2/20 20:01
     */
    @ResponseBody
    @RequestMapping(value = "/saveOrUpdateRole", produces = "application/json;charset=utf-8")
    public Result saveOrUpdateRole(SysRole role) {
        if (sysRoleService.persistenceRole(role)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(Constants.POST_DATA_FAIL);
        }
    }

    /**
     * @param request
     * @return space.dyenigma.core.Result
     * @Description : 删除角色信息
     * @author dingdongliang
     * @date 2018/2/20 20:01
     */
    @ResponseBody
    @RequestMapping(value = "/delRole", produces = "application/json;charset=utf-8")
    public Result delRole(HttpServletRequest request) {
        String roleId = request.getParameter("roleId");

        if (sysRoleService.delRole(roleId)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(Constants.IS_EXT_SUBMENU);
        }

    }

    /**
     * @param request
     * @return java.util.List<space.dyenigma.entity.SysPermission>
     * @Description : 获取某个角色的所有权限
     * @author dingdongliang
     * @date 2018/2/20 20:02
     */
    @ResponseBody
    @RequestMapping(value = "/getRolePermission", produces = "application/json;charset=utf-8")
    public List<SysPermission> getRolePermission(HttpServletRequest request) {
        String roleId = request.getParameter("roleId");
        List<SysPermission> permissions = sysRolePmsnService.findAllByRoleId(roleId);

        return permissions;
    }

    /**
     * @param request
     * @return space.dyenigma.core.Result
     * @Description : 保存某个角色的权限分配
     * @author dingdongliang
     * @date 2018/2/20 20:02
     */
    @ResponseBody
    @RequestMapping(value = "/savePermission", produces = "application/json;charset=utf-8")
    public Result savePermission(HttpServletRequest request) {
        String roleId = request.getParameter("roleId");
        String checkedIds = request.getParameter("allCheck");

        if (sysRolePmsnService.savePermission(roleId, checkedIds)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(Constants.POST_DATA_FAIL);
        }

    }

    @ResponseBody
    @RequestMapping(value = "/setDefaultRole", produces = "application/json;charset=utf-8")
    public Result setDefaultRole(HttpServletRequest request) {
        String roleId = request.getParameter("roleId");

        if (sysRolePmsnService.setDefaultRole(roleId)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(Constants.POST_DATA_FAIL);
        }
    }

    @ResponseBody
    @PostMapping
    public Result add(SysRole sysRole) {
        sysRoleService.save(sysRole);
        return ResultGenerator.genSuccessResult();
    }

    @ResponseBody
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        sysRoleService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @ResponseBody
    @PutMapping
    public Result update(SysRole sysRole) {
        sysRoleService.update(sysRole);
        return ResultGenerator.genSuccessResult();
    }

    @ResponseBody
    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        SysRole sysRole = sysRoleService.findById(id);
        return ResultGenerator.genSuccessResult(sysRole);
    }

    @ResponseBody
    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SysRole> list = sysRoleService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
