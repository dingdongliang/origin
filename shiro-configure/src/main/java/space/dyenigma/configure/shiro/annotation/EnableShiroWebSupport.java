package space.dyenigma.configure.shiro.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import space.dyenigma.configure.shiro.ShiroWebMvcConfigurerAdapter;

/**
 * origin/space.dyenigma.configure.shiro.annotation
 *
 * @Description :
 * @Author : dingdongliang
 * @Date : 2018/2/14 21:11
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Inherited
@Import({EnableShiroWebSupport.ShiroWebMvcConfigurerAdapterImportSelector.class})
public @interface EnableShiroWebSupport {

    class ShiroWebMvcConfigurerAdapterImportSelector implements ImportSelector {

        @Override
        public String[] selectImports(AnnotationMetadata importingClassMetadata) {
            return new String[]{ShiroWebMvcConfigurerAdapter.class.getName()};
        }

    }
}
