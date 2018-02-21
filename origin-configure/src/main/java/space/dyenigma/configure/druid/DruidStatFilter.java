package space.dyenigma.configure.druid;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * origin/space.dyenigma.configure.druid
 *
 * @Description: druid监控配置
 * @Author: dingdongliang
 * @Date: 2017/6/23 16:50
 */
@WebFilter(filterName = "druidWebStatFilter", urlPatterns = "/*",
        initParams = {
                @WebInitParam(name = "exclusions", value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*"),
                @WebInitParam(name = "config.decrypt", value = "true")
        })
public class DruidStatFilter extends WebStatFilter {

}
