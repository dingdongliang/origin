package space.dyenigma.control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;

/**
 * origin/space.dyenigma.control
 *
 * @Description:
 * @Author: dingdongliang
 * @Date: 2017/7/21
 */
@Controller
@ApiIgnore
@RequestMapping(value = "/manage")
public class MgrJumpController {

    private final Logger logger = LoggerFactory.getLogger(MgrJumpController.class);

    @RequestMapping(value = "/mTop", method = RequestMethod.GET)
    public String mTop(HttpServletRequest request, Model model) {
        logger.debug("mTop() is executed!");
        model.addAttribute("currUser", request.getAttribute("currUser"));
        return "manage/layout/header";
    }

    @RequestMapping(value = "/mLeft", method = RequestMethod.GET)
    public String mLeft() {
        logger.debug("mLeft() is executed!");
        return "manage/layout/left";
    }

    @RequestMapping(value = "/mFoot", method = RequestMethod.GET)
    public String mFoot() {
        logger.debug("mFoot() is executed!");
        return "manage/layout/footer";
    }

    @RequestMapping(value = "/mCenter", method = RequestMethod.GET)
    public String mCenter() {
        logger.debug("mCenter() is executed!");
        return "manage/layout/center";
    }

    @GetMapping("/main")
    public String main() {
        logger.debug("main() is executed!");
        return "manage/main";
    }
}
