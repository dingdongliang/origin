package space.dyenigma.control;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import space.dyenigma.common.Pagination;
import space.dyenigma.common.PaginationResult;
import space.dyenigma.service.ShiroRoleService;
import space.dyenigma.service.ShiroUserService;
import space.dyenigma.shiro.MyShiroRealm;
import space.dyenigma.shiro.Function;
import space.dyenigma.shiro.FunctionService;
import space.dyenigma.shiro.FunctionTreeBean;
import space.dyenigma.shiro.ShiroRole;
import space.dyenigma.util.ResponseJson;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * origin/space.dyenigma.control
 *
 * @Description : 系统功能管理模块
 * @Author : dingdongliang
 * @Date : 2018/2/15 8:07
 */
@Controller
@Slf4j
public class SysController {

    private static final Logger logger = LoggerFactory.getLogger(SysController.class);
    @Autowired
    MyShiroRealm myShiroRealm;

    @Autowired
    ShiroUserService shiroUserService;

    @Autowired
    ShiroRoleService shiroRoleService;

    @Autowired
    FunctionService functionService;

    /**
     * @param model
     * @return java.lang.String
     * @Description : 进入角色列表页面
     * @author dingdongliang
     * @date 2018/2/15 8:10
     */
    @RequestMapping(value = "/admin/sysFunctionManager/role_manager")
    public String role_manager(Model model) {

        Subject currentUser = SecurityUtils.getSubject();
        String logOperatorName = (String) currentUser.getPrincipal();

        return "admin/sysFunctionManager/role_manager";
    }

    /**
     * @param model
     * @return java.lang.String
     * @Description : 进入功能列表页面
     * @author dingdongliang
     * @date 2018/2/15 8:11
     */
    @RequestMapping(value = "/admin/sysFunctionManager/function_manager")
    public String function_manager(Model model) {

        return "admin/sysFunctionManager/function_manager";
    }

    /**
     * @param pagination
     * @return java.lang.String
     * @Description : 角色列表
     * @author dingdongliang
     * @date 2018/2/15 8:11
     */
    @RequestMapping(value = "/admin/sysFunctionManager/role_manager/list")
    @ResponseBody
    String findRoleManagerList(@RequestBody Pagination<ShiroRole> pagination) {

        PaginationResult<ShiroRole> pageResonse = shiroRoleService.findAllByPage(pagination);

        JSONObject jsonObject = (JSONObject) JSON.toJSON(pageResonse);
        logger.info(jsonObject.toJSONString());
        return jsonObject.toJSONString(pageResonse, SerializerFeature.WriteDateUseDateFormat,
                SerializerFeature.WriteMapNullValue);
    }

    /**
     * @param pagination
     * @return java.lang.String
     * @Description : 功能列表
     * @author dingdongliang
     * @date 2018/2/15 8:11
     */
    @RequestMapping(value = "/admin/sysFunctionManager/function_manager/list")
    @ResponseBody
    String findFunctionManagerList(@RequestBody Pagination<Function> pagination) {

        PaginationResult<Function> pageResonse = functionService.findAllByPage(pagination);

        JSONObject jsonObject = (JSONObject) JSON.toJSON(pageResonse);
        logger.info(jsonObject.toJSONString());
        return jsonObject.toJSONString(pageResonse, SerializerFeature.WriteDateUseDateFormat,
                SerializerFeature.WriteMapNullValue);
    }

    /**
     * @param pid
     * @param functionName
     * @param permissionName
     * @return java.lang.String
     * @Description : 添加功能
     * @author dingdongliang
     * @date 2018/2/15 8:11
     */
    @RequestMapping(value = "/admin/sysFunctionManager/addFunction")
    @ResponseBody
    public String addFunction(@RequestParam("pid") String pid, @RequestParam("functionName") String functionName, @RequestParam("permissionName") String permissionName) {
        ResponseJson responseJson = new ResponseJson();
        responseJson.setMsg("success");
        try {

            Function function = functionService.findByPermissionName(permissionName);
            if (function != null) {
                responseJson.setMsg("exist");
            } else {
                function = new Function();
                function.setCreateTime(new Date());
                function.setPermissionName(permissionName);
                function.setFunctionName(functionName);
                function.setPid(new Integer(pid));
                functionService.save(function);
            }

        } catch (Exception e) {
            responseJson.setMsg("exception");
            logger.info(e.toString());
        }
        return JSONObject.toJSONString(responseJson);
    }

    /**
     * @param id
     * @return java.lang.String
     * @Description : 删除功能
     * @author dingdongliang
     * @date 2018/2/15 8:12
     */
    @RequestMapping(value = "/admin/sysFunctionManager/delFunction")
    @ResponseBody
    public String delFunction(String id) {
        ResponseJson responseJson = new ResponseJson();
        responseJson.setMsg("success");
        try {

            List<Function> list = functionService.findListByPid(new Integer(id));
            if (list != null && !list.isEmpty()) {
                responseJson.setMsg("existChildren");//存在子节点
            } else {

                Function function = functionService.findById(new Integer(id));
                functionService.delete(function);
            }

        } catch (DataIntegrityViolationException ee) {
            responseJson.setMsg("existRoleFunction");
        } catch (Exception e) {
            responseJson.setMsg("exception");
            logger.info(e.toString());
        }
        return JSONObject.toJSONString(responseJson);
    }

    /**
     * @param id
     * @return java.lang.String
     * @Description : 进入修改功能页面
     * @author dingdongliang
     * @date 2018/2/15 8:12
     */
    @RequestMapping(value = "/admin/sysFunctionManager/toEditFunction")
    @ResponseBody
    String toEditFunction(String id) {

        Function function = functionService.findById(new Integer(id));

        return JSONObject.toJSONString(function, SerializerFeature.WriteDateUseDateFormat,
                SerializerFeature.WriteMapNullValue);
    }

    /**
     * @param function
     * @return java.lang.String
     * @Description : 功能修改
     * @author dingdongliang
     * @date 2018/2/15 8:12
     */
    @RequestMapping(value = "/admin/sysFunctionManager/editFunction")
    @ResponseBody
    public String editFunction(Function function) {
        ResponseJson responseJson = new ResponseJson();
        responseJson.setMsg("success");
        try {

            Function functionTemp = functionService.findByPermissionName(function.getPermissionName());

            if (functionTemp != null && functionTemp.getId() != function.getId()) {
                responseJson.setMsg("exist");
            } else {
                functionTemp = functionService.findById(function.getId());
                functionTemp.setCreateTime(new Date());
                functionTemp.setFunctionName(function.getFunctionName());
                functionTemp.setPermissionName(function.getPermissionName());
                functionService.save(functionTemp);

            }

        } catch (Exception e) {
            responseJson.setMsg("exception");
            logger.info(e.toString());
        }
        return JSONObject.toJSONString(responseJson);
    }

    /**
     * @param shiroRole
     * @return java.lang.String
     * @Description : 添加角色
     * @author dingdongliang
     * @date 2018/2/15 8:12
     */
    @RequestMapping(value = "/admin/sysFunctionManager/addRole")
    @ResponseBody
    public String addRole(ShiroRole shiroRole) {
        ResponseJson responseJson = new ResponseJson();
        responseJson.setMsg("success");
        try {
            ShiroRole shiroRoleTemp = shiroRoleService.findByRoleName(shiroRole.getRoleName());
            if (shiroRoleTemp != null) {
                responseJson.setMsg("exist");
            } else if (shiroRole.getRoleName().equals("admin")) {//内置超级管理员权限，不可以重复注册

                responseJson.setMsg("admin");

            } else {
                shiroRole.setCreateTime(new Date());
                shiroRoleService.save(shiroRole);
                //begin 添加记录日志功能
                Subject currentUser = SecurityUtils.getSubject();
                String logOperatorName = (String) currentUser.getPrincipal();
                //end   添加记录日志功能
            }

        } catch (Exception e) {
            responseJson.setMsg("exception");
            logger.info(e.toString());
        }
        return JSONObject.toJSONString(responseJson);
    }

    /**
     * @param id
     * @return java.lang.String
     * @Description : 进入修改角色页面
     * @author dingdongliang
     * @date 2018/2/15 8:13
     */
    @RequestMapping(value = "/admin/sysFunctionManager/toEditRolePage")
    @ResponseBody
    public String toEditRolePage(String id) {
        ResponseJson responseJson = new ResponseJson();
        responseJson.setMsg("success");
        ShiroRole shiroRoleTemp = shiroRoleService.findById(new Integer(id));
        return JSONObject.toJSONString(shiroRoleTemp);
    }

    /**
     * @param shiroRole
     * @return java.lang.String
     * @Description : 修改角色
     * @author dingdongliang
     * @date 2018/2/15 8:14
     */
    @RequestMapping(value = "/admin/sysFunctionManager/editRole")
    @ResponseBody
    public String editRole(ShiroRole shiroRole) {
        ResponseJson responseJson = new ResponseJson();
        responseJson.setMsg("success");

        if (shiroRoleService.findById(shiroRole.getId()).getRoleName().equals("管理员")) {
            responseJson.setMsg("admin");
            return JSONObject.toJSONString(responseJson);
        }
        try {
            ShiroRole shiroRoleTemp1 = shiroRoleService.findByRoleName(shiroRole.getRoleName());

            ShiroRole shiroRoleTemp2 = shiroRoleService.findById(shiroRole.getId());
            if (shiroRoleTemp1 != null && shiroRoleTemp1.getId() != shiroRole.getId()) {
                responseJson.setMsg("exist");
            } else {
                shiroRoleTemp2.setCreateTime(new Date());
                shiroRoleTemp2.setRoleName(shiroRole.getRoleName());
                shiroRoleService.save(shiroRoleTemp2);

                //begin 添加记录日志功能
                Subject currentUser = SecurityUtils.getSubject();
                String logOperatorName = (String) currentUser.getPrincipal();
                //end   添加记录日志功能
            }

        } catch (Exception e) {
            responseJson.setMsg("exception");
            logger.info(e.toString());
        }
        return JSONObject.toJSONString(responseJson);
    }

    /**
     * @param id
     * @return java.lang.String
     * @Description : 删除角色
     * @author dingdongliang
     * @date 2018/2/15 8:15
     */
    @RequestMapping(value = "/admin/sysFunctionManager/delRole/{id}")
    @ResponseBody
    String toSystemOrgManagerEditPage(@PathVariable("id") String id) {
        ResponseJson responseJson = new ResponseJson();
        responseJson.setMsg("success");
        try {

            ShiroRole shiroRole = shiroRoleService.findById(new Integer(id));

            if (shiroRole.getRoleName().equals("管理员")) {

                responseJson.setMsg("admin");

            } else {
                shiroRoleService.delete(shiroRole);
                //begin 添加记录日志功能
                Subject currentUser = SecurityUtils.getSubject();
                String logOperatorName = (String) currentUser.getPrincipal();
                //end   添加记录日志功能
            }

        } catch (DataIntegrityViolationException e) {
            responseJson.setMsg("exist");
            logger.info(e.toString());
        } catch (Exception e) {
            responseJson.setMsg("exception");
            logger.info(e.toString());
        }
        return JSONObject.toJSONString(responseJson);

    }

    /**
     * @param
     * @return java.lang.String
     * @Description : 进入角色列表页面
     * @author dingdongliang
     * @date 2018/2/15 8:15
     */
    @RequestMapping(value = "/admin/sysFunctionManager/function_tree")
    public String function_tree() {

        return "admin/sysFunctionManager/function_tree";
    }

    /**
     * @param
     * @return java.lang.String
     * @Description : 给角色添加功能，进入功能tree页面
     * @author dingdongliang
     * @date 2018/2/15 8:15
     */
    @RequestMapping(value = "/admin/sysFunctionManager/role_function_tree")
    public String role_function_tree() {

        return "admin/sysFunctionManager/role_function_tree";
    }

    /**
     * @param
     * @return java.lang.String
     * @Description : 获取目录tree列表数据-添加功能
     * @author dingdongliang
     * @date 2018/2/15 8:16
     */
    @RequestMapping(value = "/admin/sysFunctionManager/initTree/list")
    @ResponseBody
    String initTree() {

        List<Function> list = functionService.findList();
        List<FunctionTreeBean> list2 = new ArrayList<>();
        for (Function function : list) {

            FunctionTreeBean functionTreeBean = new FunctionTreeBean();
            functionTreeBean.setId(function.getId());
            functionTreeBean.setParentId(function.getPid());
            functionTreeBean.setName(function.getFunctionName());
            list2.add(functionTreeBean);

        }

        return JSONObject.toJSONString(list2, SerializerFeature.WriteDateUseDateFormat,
                SerializerFeature.WriteMapNullValue);
    }

    /**
     * @param roleId
     * @return java.lang.String
     * @Description : 获取目录tree列表数据-给角色添加功能，回显功能。
     * @author dingdongliang
     * @date 2018/2/15 8:16
     */
    @RequestMapping(value = "/admin/sysFunctionManager/roleFucntionTreeData")
    @ResponseBody
    String roleFucntionTreeData(String roleId) {
        List<FunctionTreeBean> list2 = new ArrayList<>();
        Map map = new HashMap<>();
        ShiroRole shiroRole = shiroRoleService.findById(new Integer(roleId));

        List<Function> list_1 = shiroRole.getFunctionList();
        for (Function function : list_1) {
            map.put(function.getId(), true);
        }

        List<Function> list = functionService.findList();

        for (Function function : list) {

            FunctionTreeBean functionTreeBean = new FunctionTreeBean();
            functionTreeBean.setId(function.getId());
            functionTreeBean.setParentId(function.getPid());
            functionTreeBean.setName(function.getFunctionName());

            if (map.get(function.getId()) != null) {
                functionTreeBean.setChecked(true);
            }

            list2.add(functionTreeBean);

        }

        return JSONObject.toJSONString(list2, SerializerFeature.WriteDateUseDateFormat,
                SerializerFeature.WriteMapNullValue);
    }

    /**
     * @param functionIds
     * @param roleId
     * @return java.lang.String
     * @Description : 给角色添加功能
     * @author dingdongliang
     * @date 2018/2/15 8:16
     */
    @RequestMapping(value = "/admin/sysFunctionManager/addRoleFunction")
    @ResponseBody
    String addRoleFunction(String functionIds, String roleId) {
        ResponseJson responseJson = new ResponseJson();
        responseJson.setMsg("success");
        logger.info("functionIds==" + functionIds);
        logger.info("roleId==" + roleId);
        try {

            ShiroRole shiroRole = shiroRoleService.findById(new Integer(roleId));

            List<Function> functionList = new ArrayList<>();

            if (!functionIds.equals("")) {
                String functionIdsArray[] = functionIds.split(",");

                for (int i = 0; i < functionIdsArray.length; i++) {
                    Function function = functionService.findById(new Integer(functionIdsArray[i]));
                    functionList.add(function);
                }
            }

            shiroRole.setFunctionList(functionList);
            shiroRoleService.save(shiroRole);

            //begin 添加记录日志功能
            Subject currentUser = SecurityUtils.getSubject();
            String logOperatorName = (String) currentUser.getPrincipal();
            //end   添加记录日志功能

        } catch (Exception e) {
            responseJson.setMsg("exception");
            logger.info(e.toString());
        }
        return JSONObject.toJSONString(responseJson);
    }
}