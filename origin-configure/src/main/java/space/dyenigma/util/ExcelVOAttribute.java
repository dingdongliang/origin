package space.dyenigma.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * origin/space.dyenigma.util
 *
 * @Description: 带有该注解的字段才能被输出
 * @Author: dingdongliang
 * @Date: 2016/4/5 15:56
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface ExcelVOAttribute {

    /**
     * 列名
     */
    String name();

    /**
     * 列号
     */
    String column();

    /**
     * 提示信息，默认为空
     */
    String prompt() default "";

    /**
     * 限定下拉框
     */
    String[] combo() default {};

    /**
     * 是否导出，默认true
     */
    boolean isExport() default true;
}
