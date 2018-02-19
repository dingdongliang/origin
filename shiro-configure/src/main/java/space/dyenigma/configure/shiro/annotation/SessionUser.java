package space.dyenigma.configure.shiro.annotation;

import java.lang.annotation.*;

/**
 * origin/space.dyenigma.configure.shiro.annotation
 *
 * @Description : 获取当前用户
 * @Author : dingdongliang
 * @Date : 2018/2/14 21:14
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SessionUser {
}