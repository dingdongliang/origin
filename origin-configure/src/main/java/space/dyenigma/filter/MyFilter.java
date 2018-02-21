package space.dyenigma.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * origin/space.dyenigma.filter
 *
 * @Description: 使用注解标注过滤器，WebFilter将一个实现了javax.servlet.Filter接口的类定义为过滤器，属性filterName声明过滤器的名称,
 * 可选属性urlPatterns指定要过滤的URL模式,也可使用属性value来声明.(指定要过滤的URL模式是必选属性)
 * @Author: dingdongliang
 * @Date: 2017/6/27 11:41
 * P.S. 按关键字进行排除过滤，多个关键字用竖线分隔,如果有其他过滤需求，请同步修改该类的处理代码
 */
@WebFilter(filterName = "myFilter", urlPatterns = "/*"
        , initParams = {@WebInitParam(name = "exclusions", value = "/druid/|/swagger|swagger-ui|.jpg")})
public class MyFilter implements Filter {
    private Logger logger = LoggerFactory.getLogger(MyFilter.class);
    private List<String> excluded;

    /**
     * 过滤器初始化，同时初始化排除规则内容，以竖线隔开
     * param config
     * throws ServletException
     */
    @Override
    public void init(FilterConfig config) throws ServletException {
        logger.debug("过滤器初始化");

        String excludedString = config.getInitParameter("exclusions");
        if (excludedString != null) {
            excluded = Arrays.asList(excludedString.split("\\|", 0));
        } else {
            excluded = null;
        }
    }

    /**
     * 获取请求URI，然后判断是否在排除规则之内
     * param request
     * return
     */
    private boolean isExcluded(HttpServletRequest request) {
        String path = request.getRequestURI();
        for (String str : excluded) {
            if (path.indexOf(str) >= 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;

        if (isExcluded(httpRequest)) {
            chain.doFilter(request, response);
        } else {
            logger.debug("执行过滤操作" + ((HttpServletRequest) request).getRequestURI());
            //Do your stuff here
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        logger.debug("过滤器销毁");
        this.excluded = null;
    }
}