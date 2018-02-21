package space.dyenigma.control;

import space.dyenigma.core.Result;
import space.dyenigma.core.ResultGenerator;
import space.dyenigma.entity.SysCompany;
import space.dyenigma.model.GridModel;
import space.dyenigma.model.TreeModel;
import space.dyenigma.service.ISysCompanyService;
import space.dyenigma.util.Constants;
import space.dyenigma.util.ExcelUtil;
import space.dyenigma.util.PageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.apache.commons.io.FileUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * origin/space.dyenigma.control
 *
 * @Description:
 * @Author: dingdongliang
 * @Date: 2017/7/21
 */
@Controller
@Api(description = "公司管理API")
@RequestMapping(value = "/manage/comp")
public class SysCompanyController {

    private final Logger logger = LoggerFactory.getLogger(SysCompanyController.class);

    @Resource
    private ISysCompanyService sysCompanyService;

    @RequestMapping("/compMain")
    public String compMain() {
        logger.debug("compMain() is executed!");
        return "manage/company/coMain";
    }

    /**
     * @param
     * @return java.util.List<space.dyenigma.model.TreeModel>
     * @Description : 显示所有可添加子项的菜单项
     * @author dingdongliang
     * @date 2018/2/20 19:57
     */
    @ResponseBody
    @RequestMapping(value = "/findSuperComp", produces = "application/json;charset=utf-8")
    public List<TreeModel> findSuperComp() {
        return sysCompanyService.getAllCoName();
    }

    /**
     * @param request
     * @return java.util.List<space.dyenigma.entity.SysCompany>
     * @Description : 显示所有可操作的菜单项，用于菜单编辑页面
     * @author dingdongliang
     * @date 2018/2/20 19:57
     */
    @ResponseBody
    @RequestMapping(value = "/findAllCoList", produces = "application/json;charset=utf-8")
    public List<SysCompany> findAllCoList(HttpServletRequest request) {
        String coId = request.getParameter("id");
        return sysCompanyService.findByPid(coId);
    }

    @ResponseBody
    @RequestMapping(value = "/getAllCo", produces = "application/json;charset=utf-8")
    public List<SysCompany> getAllCo() {
        return sysCompanyService.findAll();
    }

    /**
     * @param request
     * @return space.dyenigma.model.GridModel
     * @Description : 分页查询公司信息
     * @author dingdongliang
     * @date 2018/2/20 19:57
     */
    @ResponseBody
    @RequestMapping(value = "/findComp", produces = "application/json;charset=utf-8")
    public GridModel findComp(HttpServletRequest request) {
        logger.debug("findComp() is executed!");
        int pageNo = Integer.parseInt(request.getParameter("page"));
        int length = Integer.parseInt(request.getParameter("rows"));
        PageUtil pageUtil = new PageUtil((pageNo - 1) * length, length);
        GridModel gridModel = new GridModel();
        gridModel.setRows(sysCompanyService.findComp(pageUtil));
        gridModel.setTotal(sysCompanyService.getCount(null));
        return gridModel;
    }

    /**
     * @param
     * @return java.lang.String
     * @Description : 弹出添加公司层
     * @author dingdongliang
     * @date 2018/2/20 19:57
     */
    @RequestMapping(value = "/companyEditDlg", method = RequestMethod.GET)
    public String companyEditDlg() {

        logger.debug("companyEditDlg() is executed!");

        return "manage/company/coEdit";
    }

    /**
     * @param company
     * @return space.dyenigma.core.Result
     * @Description : 添加或者修改公司信息,需要在控制器上也添加权限控制
     * @author dingdongliang
     * @date 2018/2/20 19:57
     */
    @RequiresPermissions({"coAdd", "coEdit"})
    @ResponseBody
    @RequestMapping(value = "/saveOrUpdateComp", produces = "application/json;charset=utf-8")
    public Result saveOrUpdateComp(SysCompany company) {
        //可以限制只能添加多少公司
        if (sysCompanyService.persistenceComp(company)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(Constants.POST_DATA_FAIL);
        }
    }

    /**
     * @param request
     * @return space.dyenigma.core.Result
     * @Description : 删除公司信息,在删除之前判断是否包含组织信息
     * @author dingdongliang
     * @date 2018/2/20 19:57
     */
    @RequiresPermissions({"coDel"})
    @ResponseBody
    @RequestMapping(value = "/delComp", produces = "application/json;charset=utf-8")
    public Result delComp(HttpServletRequest request) {
        String id = request.getParameter("coId");

        if (sysCompanyService.delComp(id)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(Constants.IS_EXT_SUBMENU);
        }
    }

    /**
     * @param companyId
     * @param request
     * @return org.springframework.http.ResponseEntity<byte               [               ]>
     * @Description : 导出excel，注意该方法不能使用ajax调用，因为ajax不支持流
     * @author dingdongliang
     * @date 2018/2/20 19:57
     */
    @RequestMapping(value = "/excelExport/{coId}")
    public ResponseEntity<byte[]> excelExport(@PathVariable("coId") String companyId, HttpServletRequest request) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String excelName = format.format(new Date());
        String path = "SysCompany-" + excelName + ".xls";

        //获取绝对路径,如果realPath获取不到,尝试更换getRealPath方法的参数
        String realPath = request.getSession().getServletContext().getRealPath("/");

        String allPath = realPath + "download";

        FileOutputStream out = null;
        try {
            File file = new File(allPath);
            if (!file.exists()) {
                file.mkdirs();
            }
            out = new FileOutputStream(allPath + File.separator + path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //获取company资料写入文件
        List<SysCompany> list = new ArrayList<>();
        list.add(sysCompanyService.findBy("coId", companyId));
        ExcelUtil<SysCompany> util = new ExcelUtil<>(SysCompany.class);
        util.exportExcel(list, "Sheet", 60000, out);

        //下载文件处理
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", path);
        byte[] bytes = new byte[0];
        try {
            File file = new File(allPath);
            bytes = FileUtils.readFileToByteArray(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(bytes, headers, HttpStatus.CREATED);
    }

    @PostMapping
    public Result add(SysCompany sysCompany) {
        sysCompanyService.save(sysCompany);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        sysCompanyService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(SysCompany sysCompany) {
        sysCompanyService.update(sysCompany);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        SysCompany sysCompany = sysCompanyService.findById(id);
        return ResultGenerator.genSuccessResult(sysCompany);
    }

    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SysCompany> list = sysCompanyService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
