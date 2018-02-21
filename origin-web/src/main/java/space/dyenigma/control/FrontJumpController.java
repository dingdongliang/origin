package space.dyenigma.control;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * origin/space.dyenigma.control
 *
 * @Description: 前台页面跳转控制
 * @Author: dingdongliang
 * @Date: 2017/7/21 15:39
 */
@Controller
@Api(description = "客户前端页面展示API")
@RequestMapping(value = "/front")
public class FrontJumpController {

    private final Logger logger = LoggerFactory.getLogger(FrontJumpController.class);

    @GetMapping(value = "/base")
    public String base() {
        logger.debug("base() is executed!");
        return "main/base";
    }

    @GetMapping(value = "/main")
    public String main() {
        logger.debug("main() is executed!");
        return "main/main";
    }

    @GetMapping(value = "/adv")
    public String adv() {
        logger.debug("adv() is executed!");
        return "main/adv";
    }

    @GetMapping(value = "/web")
    public String web() {
        logger.debug("web() is executed!");
        return "main/web";
    }

    @GetMapping(value = "/sources")
    public String sources() {
        logger.debug("sources() is executed!");
        return "main/sources";
    }

    @GetMapping(value = "/database")
    public String database() {
        logger.debug("database() is executed!");
        return "main/database";
    }

    @GetMapping(value = "/question")
    public String question() {
        logger.debug("question() is executed!");
        return "main/question";
    }

    @GetMapping(value = "/life")
    public String life() {
        logger.debug("life() is executed!");
        return "main/life";
    }

    @GetMapping(value = "/tools")
    public String tools() {
        logger.debug("tools() is executed!");
        return "main/tools";
    }
}
