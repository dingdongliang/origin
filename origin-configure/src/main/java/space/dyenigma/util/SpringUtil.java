package space.dyenigma.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public final class SpringUtil implements BeanFactoryPostProcessor {

    private static ConfigurableListableBeanFactory beanFactory;

    /**
     * @param name
     * @return T
     * @Description : 获取对象
     * @author dingdongliang
     * @date 2018/2/20 19:42
     */
    public static <T> T getBean(String name) throws BeansException {
        return (T) beanFactory.getBean(name);
    }

    /**
     * @param clz
     * @return T
     * @Description : 获取类型为requiredType的对象
     * @author dingdongliang
     * @date 2018/2/20 19:42
     */
    public static <T> T getBean(Class<T> clz) throws BeansException {

        T result = beanFactory.getBean(clz);
        return result;
    }

    /**
     * @param name
     * @return boolean
     * @Description : 如果BeanFactory包含一个与所给名称匹配的bean定义，则返回true
     * @author dingdongliang
     * @date 2018/2/20 19:42
     */
    public static boolean containsBean(String name) {
        return beanFactory.containsBean(name);
    }

    /**
     * @param name
     * @return boolean
     * @Description : 判断以给定名字注册的bean定义是一个singleton还是一个prototype。 如果与给定名字相应的bean定义没有被找到，将会抛出一个异常（NoSuchBeanDefinitionException）
     * @author dingdongliang
     * @date 2018/2/20 19:43
     */
    public static boolean isSingleton(String name) throws NoSuchBeanDefinitionException {
        return beanFactory.isSingleton(name);
    }

    public static Class<?> getType(String name) throws NoSuchBeanDefinitionException {
        return beanFactory.getType(name);
    }

    /**
     * @param name
     * @return java.lang.String[]
     * @Description : 如果给定的bean名字在bean定义中有别名，则返回这些别名
     * @author dingdongliang
     * @date 2018/2/20 19:43
     */
    public static String[] getAliases(String name) throws NoSuchBeanDefinitionException {
        return beanFactory.getAliases(name);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        SpringUtil.beanFactory = beanFactory;
    }
}
