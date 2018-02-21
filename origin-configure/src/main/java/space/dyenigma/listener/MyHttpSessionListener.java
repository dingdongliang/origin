package space.dyenigma.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * origin/space.dyenigma.listener
 *
 * @Description: 监听Session的创建与销毁
 * @Author: dingdongliang
 * @Date: 2017/6/27 11:43
 */
@WebListener
public class MyHttpSessionListener implements HttpSessionListener {
    private Logger logger = LoggerFactory.getLogger(MyHttpSessionListener.class);

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        logger.debug("Session 被创建");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        logger.debug("ServletContex初始化");
    }

}
