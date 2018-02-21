package space.dyenigma.control;

import space.dyenigma.core.Result;
import space.dyenigma.core.ResultGenerator;
import space.dyenigma.entity.SysPost;
import space.dyenigma.entity.SysPostRole;
import space.dyenigma.model.TreeModel;
import space.dyenigma.service.ISysPostRoleService;
import space.dyenigma.service.ISysPostService;
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
@Api(description = "岗位管理API")
@RequestMapping(value = "/manage/post")
public class SysPostController {

    private final Logger logger = LoggerFactory.getLogger(SysPostController.class);

    @Resource
    private ISysPostService sysPostService;
    @Resource
    private ISysPostRoleService sysPostRoleService;

    @RequestMapping("/postMain")
    public String main() {
        logger.debug("main() is executed!");
        return "manage/post/postMain";
    }

    @ResponseBody
    @RequestMapping(value = "/getCoDivList", produces = "application/json;charset=utf-8")
    public List<TreeModel> getCoDivList() {
        return sysPostService.getCoDivList();
    }

    /**
     * @param
     * @return java.lang.String
     * @Description : 查看每个岗位的用户列表
     * @author dingdongliang
     * @date 2018/2/20 19:59
     */
    @RequestMapping("/postView")
    public String postView() {
        logger.debug("postView() is executed!");
        return "manage/post/postView";
    }

    /**
     * @param divId
     * @return java.util.List<space.dyenigma.entity.SysPost>
     * @Description : 按部门查询所有岗位
     * @author dingdongliang
     * @date 2018/2/20 19:59
     */
    @ResponseBody
    @RequestMapping(value = "/findPostByDiv/{divId}", produces = "application/json;charset=utf-8")
    public List<SysPost> findPostByDiv(@PathVariable("divId") String divId) {
        return sysPostService.finaPostByDiv(divId);
    }

    /**
     * @param
     * @return java.lang.String
     * @Description : 跳转到编辑组织页面
     * @author dingdongliang
     * @date 2018/2/20 19:59
     */
    @RequestMapping(value = "/postEdit", method = RequestMethod.GET)
    public String postEdit() {

        logger.debug("postEdit() is executed!");

        return "manage/post/postEdit";
    }

    /**
     * @param
     * @return java.lang.String
     * @Description : 跳转到编辑组织页面
     * @author dingdongliang
     * @date 2018/2/20 19:59
     */
    @RequestMapping(value = "/toSetRole", method = RequestMethod.GET)
    public String toSetRole() {

        logger.debug("toSetRole() is executed!");

        return "manage/post/postRole";
    }

    /**
     * @param request
     * @return space.dyenigma.core.Result
     * @Description : 保存岗位关联的角色
     * @author dingdongliang
     * @date 2018/2/20 19:59
     */
    @ResponseBody
    @RequestMapping(value = "/savePostRole", produces = "application/json;charset=utf-8")
    public Result savePostRole(HttpServletRequest request) {
        String postId = request.getParameter("postId");
        String checkedIds = request.getParameter("allCheck");

        if (sysPostRoleService.savePostRole(postId, checkedIds)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(Constants.POST_DATA_FAIL);
        }
    }

    /**
     * @param request
     * @return space.dyenigma.core.Result
     * @Description : 删除组织处理
     * @author dingdongliang
     * @date 2018/2/20 19:59
     */
    @ResponseBody
    @RequestMapping(value = "/delPost", produces = "application/json;charset=utf-8")
    public Result delPost(HttpServletRequest request) {
        String postId = request.getParameter("id");

        if (sysPostService.invalidByPrimaryKey(postId) > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(Constants.IS_EXT_SUBMENU);
        }

    }

    /**
     * @param post
     * @return space.dyenigma.core.Result
     * @Description : 新增岗位或者更新岗位处理
     * @author dingdongliang
     * @date 2018/2/20 19:59
     */
    @ResponseBody
    @RequestMapping(value = "/saveOrUpdatePost", produces = "application/json;charset=utf-8")
    public Result saveOrUpdatePost(SysPost post) {
        if (sysPostService.persistencePost(post)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(Constants.POST_DATA_FAIL);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/getPostRoleByPostId", produces = "application/json;charset=utf-8")
    public List<SysPostRole> getPostRoleByPostId(HttpServletRequest request) {
        String postId = request.getParameter("postId");
        return sysPostRoleService.getPostRoleByPostId(postId);
    }

    @ResponseBody
    @PostMapping
    public Result add(SysPost sysPost) {
        sysPostService.save(sysPost);
        return ResultGenerator.genSuccessResult();
    }

    @ResponseBody
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        sysPostService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @ResponseBody
    @PutMapping
    public Result update(SysPost sysPost) {
        sysPostService.update(sysPost);
        return ResultGenerator.genSuccessResult();
    }

    @ResponseBody
    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        SysPost sysPost = sysPostService.findById(id);
        return ResultGenerator.genSuccessResult(sysPost);
    }

    @ResponseBody
    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SysPost> list = sysPostService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
