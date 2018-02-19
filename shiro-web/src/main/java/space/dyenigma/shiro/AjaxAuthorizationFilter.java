package space.dyenigma.shiro;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

/**
 * origin/space.dyenigma.shiro
 *
 * @Description : 1.自定义角色鉴权过滤器(满足其中一个角色则认证通过) 2.扩展异步请求认证提示功能;
 * @Author : dingdongliang
 * @Date : 2018/2/15 8:51
 */
public class AjaxAuthorizationFilter extends AuthorizationFilter {

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;

        Subject subject = getSubject(request, response);

        if (subject.getPrincipal() == null) {
            if (isAjaxRequest(httpRequest)) {

            } else {
                saveRequestAndRedirectToLogin(request, response);
            }
        } else {
            return true;
        }

        return false;
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
            throws Exception {
        return false;
    }

    /**
     * @param request HttpServletRequest
     * @return boolean 是true, 否false
     * @Description : 判断是否为Ajax请求
     * @author dingdongliang
     * @date 2018/2/15 8:52
     */
    public static boolean isAjaxRequest(HttpServletRequest request) {
        String requestType = request.getHeader("X-Requested-With");
        if (requestType != null && requestType.equals("XMLHttpRequest")) {
            return true;
        } else {
            return false;
        }
    }

}