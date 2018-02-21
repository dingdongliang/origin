package space.dyenigma.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * origin/space.dyenigma.listener
 *
 * @Description: 使用@WebListener注解，实现ServletContextListener接口
 * @Author: dingdongliang
 * @Date: 2017/6/27 11:42
 */
@WebListener
public class MyServletContextListener implements ServletContextListener {
    private Logger logger = LoggerFactory.getLogger(MyServletContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.debug("ServletContex初始化");
        logger.debug(sce.getServletContext().getServerInfo());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.debug("ServletContex销毁");
    }

}