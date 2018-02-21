package space.dyenigma.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * origin/space.dyenigma.annotation
 *
 * @Description: 在方法上使用，用于指定使用哪个数据源
 * @Author: dingdongliang
 * @Date: 2017/7/25 10:30
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    String name();
}