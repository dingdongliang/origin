package space.dyenigma.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * origin/space.dyenigma.control
 *
 * @Description : 静态页面跳转控制
 * @Author : dingdongliang
 * @Date : 2018/2/16 10:17
 */
@Controller
public class JumpController {

    /**
     * @param
     * @return java.lang.String
     * @Description : 登录页面
     * @author dingdongliang
     * @date 2018/2/16 10:20
     */
    @RequestMapping(value = "/index")
    public String index() {
        return "manage/index";
    }

    /**
     * @param
     * @return java.lang.String
     * @Description : 登录页面
     * @author dingdongliang
     * @date 2018/2/16 10:20
     */
    @RequestMapping(value = "/")
    public String login() {
        return "login";
    }

    /**
     * @param
     * @return java.lang.String
     * @Description : 盒式布局页面
     * @author dingdongliang
     * @date 2018/2/18 9:03
     */
    @RequestMapping(value = "/layout/boxed")
    public String boxed() {
        return "manage/layout/boxed";
    }

    /**
     * @param
     * @return java.lang.String
     * @Description : 固定布局页面
     * @author dingdongliang
     * @date 2018/2/18 9:03
     */
    @RequestMapping(value = "/layout/fixed")
    public String fixed() {
        return "manage/layout/fixed";
    }

    /**
     * @param
     * @return java.lang.String
     * @Description : 折叠侧边栏页面
     * @author dingdongliang
     * @date 2018/2/18 9:03
     */
    @RequestMapping(value = "/layout/collapsedsidebar")
    public String collapsedsidebar() {
        return "manage/layout/collapsedsidebar";
    }

    /**
     * @param
     * @return java.lang.String
     * @Description : 小工具
     * @author dingdongliang
     * @date 2018/2/18 9:04
     */
    @RequestMapping(value = "/widgets")
    public String widgets() {
        return "manage/widgets";
    }

    /**
     * @param
     * @return java.lang.String
     * @Description : chartjs页面
     * @author dingdongliang
     * @date 2018/2/18 9:07
     */
    @RequestMapping(value = "/charts/chartjs")
    public String chartjs() {
        return "manage/charts/chartjs";
    }

    /**
     * @param
     * @return java.lang.String
     * @Description : morris页面
     * @author dingdongliang
     * @date 2018/2/18 9:07
     */
    @RequestMapping(value = "/charts/morris")
    public String morris() {
        return "manage/charts/morris";
    }

    /**
     * @param
     * @return java.lang.String
     * @Description : flot页面
     * @author dingdongliang
     * @date 2018/2/18 9:06
     */
    @RequestMapping(value = "/charts/flot")
    public String flot() {
        return "manage/charts/flot";
    }

    /**
     * @param
     * @return java.lang.String
     * @Description : inline charts页面
     * @author dingdongliang
     * @date 2018/2/18 9:06
     */
    @RequestMapping(value = "/charts/inline")
    public String inline() {
        return "manage/charts/inline";
    }

    /**
     * @param
     * @return java.lang.String
     * @Description : 日历页面
     * @author dingdongliang
     * @date 2018/2/18 9:08
     */
    @RequestMapping(value = "/calendar")
    public String calendar() {
        return "manage/calendar";
    }

    /**
     * @param
     * @return java.lang.String
     * @Description : 邮件页面
     * @author dingdongliang
     * @date 2018/2/18 9:09
     */
    @RequestMapping(value = "/mailbox")
    public String mailbox() {
        return "manage/mailbox/mailbox";
    }

    /**
     * @param
     * @return java.lang.String
     * @Description : 写新邮件
     * @author dingdongliang
     * @date 2018/2/18 17:15
     */
    @RequestMapping(value = "/mailbox/compose")
    public String compose() {
        return "manage/mailbox/compose";
    }

    /**
     * @param
     * @return java.lang.String
     * @Description : 读取邮件内容
     * @author dingdongliang
     * @date 2018/2/18 17:15
     */
    @RequestMapping(value = "/mailbox/readMail")
    public String readMail() {
        return "manage/mailbox/readMail";
    }

    /**
     * @param
     * @return java.lang.String
     * @Description : UI通用页面
     * @author dingdongliang
     * @date 2018/2/18 9:10
     */
    @RequestMapping(value = "/UI/general")
    public String UIGeneral() {
        return "manage/UI/general";
    }

    /**
     * @param
     * @return java.lang.String
     * @Description : 图标页面
     * @author dingdongliang
     * @date 2018/2/18 9:10
     */
    @RequestMapping(value = "/UI/icons")
    public String icons() {
        return "manage/UI/icons";
    }

    /**
     * @param
     * @return java.lang.String
     * @Description : 按钮页面
     * @author dingdongliang
     * @date 2018/2/18 9:10
     */
    @RequestMapping(value = "/UI/buttons")
    public String buttons() {
        return "manage/UI/buttons";
    }

    /**
     * @param
     * @return java.lang.String
     * @Description : 滑动条页面
     * @author dingdongliang
     * @date 2018/2/18 9:11
     */
    @RequestMapping(value = "/UI/sliders")
    public String sliders() {
        return "manage/UI/sliders";
    }

    /**
     * @param
     * @return java.lang.String
     * @Description : 时间轴页面
     * @author dingdongliang
     * @date 2018/2/18 9:11
     */
    @RequestMapping(value = "/UI/timeline")
    public String timeline() {
        return "manage/UI/timeline";
    }

    /**
     * @param
     * @return java.lang.String
     * @Description : 模态框页面
     * @author dingdongliang
     * @date 2018/2/18 9:11
     */
    @RequestMapping(value = "/UI/modals")
    public String modals() {
        return "manage/UI/modals";
    }

    /**
     * @param
     * @return java.lang.String
     * @Description : 表单通用元素
     * @author dingdongliang
     * @date 2018/2/18 9:13
     */
    @RequestMapping(value = "/forms/general")
    public String formsGeneral() {
        return "manage/forms/general";
    }

    /**
     * @param
     * @return java.lang.String
     * @Description : 表单扩展元素
     * @author dingdongliang
     * @date 2018/2/18 9:14
     */
    @RequestMapping(value = "/forms/advanced")
    public String advanced() {
        return "manage/forms/advanced";
    }

    /**
     * @param
     * @return java.lang.String
     * @Description : 表单编辑
     * @author dingdongliang
     * @date 2018/2/18 9:14
     */
    @RequestMapping(value = "/forms/editors")
    public String editors() {
        return "manage/forms/editors";
    }

    /**
     * @param
     * @return java.lang.String
     * @Description : 简单表格页面
     * @author dingdongliang
     * @date 2018/2/18 9:15
     */
    @RequestMapping(value = "/tables/simple")
    public String simpleTable() {
        return "manage/tables/simple";
    }

    /**
     * @param
     * @return java.lang.String
     * @Description : 数据表格页面
     * @author dingdongliang
     * @date 2018/2/18 9:15
     */
    @RequestMapping(value = "/tables/data")
    public String dataTable() {
        return "manage/tables/data";
    }

    /**
     * @param
     * @return java.lang.String
     * @Description : 单据页面
     * @author dingdongliang
     * @date 2018/2/18 9:16
     */
    @RequestMapping(value = "/examples/invoice")
    public String invoice() {
        return "manage/examples/invoice";
    }

    /**
     * @param
     * @return java.lang.String
     * @Description : 个人资料页面
     * @author dingdongliang
     * @date 2018/2/18 9:17
     */
    @RequestMapping(value = "/examples/profile")
    public String Profile() {
        return "manage/examples/Profile";
    }

    /**
     * @param
     * @return java.lang.String
     * @Description : 注册页面
     * @author dingdongliang
     * @date 2018/2/18 9:18
     */
    @RequestMapping(value = "/register")
    public String register() {
        return "register";
    }

    /**
     * @param
     * @return java.lang.String
     * @Description : 锁屏页面
     * @author dingdongliang
     * @date 2018/2/18 9:18
     */
    @RequestMapping(value = "/examples/lockscreen")
    public String lockscreen() {
        return "manage/examples/lockscreen";
    }

    /**
     * @param
     * @return java.lang.String
     * @Description : 404页面
     * @author dingdongliang
     * @date 2018/2/18 9:19
     */
    @RequestMapping(value = "/noPage")
    public String noPage() {
        return "manage/examples/404";
    }

    /**
     * @param
     * @return java.lang.String
     * @Description : 服务器出错
     * @author dingdongliang
     * @date 2018/2/18 9:19
     */
    @RequestMapping(value = "/noServer")
    public String noServer() {
        return "manage/examples/500";
    }

    /**
     * @param
     * @return java.lang.String
     * @Description : 空白页面
     * @author dingdongliang
     * @date 2018/2/18 9:20
     */
    @RequestMapping(value = "/blank")
    public String blank() {
        return "manage/examples/blank";
    }

    /**
     * @param
     * @return java.lang.String
     * @Description : 等待页面
     * @author dingdongliang
     * @date 2018/2/18 9:20
     */
    @RequestMapping(value = "/pace")
    public String pace() {
        return "manage/examples/pace";
    }
}
