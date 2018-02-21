package space.dyenigma.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

@SuppressWarnings("rawtypes")
public class GenericsUtil {

    private GenericsUtil() {
    }

    /**
     * @param clazz
     * @return java.lang.Class
     * @Description : 通过反射, 获得定义Class时声明的父类的范型参数的类型.
     * @author dingdongliang
     * @date 2018/2/20 19:40
     */
    public static Class getSuperClassGenricType(Class clazz) {
        return getSuperClassGenricType(clazz, 0);
    }

    /**
     * @param clazz
     * @param index
     * @return java.lang.Class
     * @Description : 通过反射, 获得定义Class时声明的父类的范型参数的类型.
     * @author dingdongliang
     * @date 2018/2/20 19:40
     */
    public static Class getSuperClassGenricType(Class clazz, int index) throws IndexOutOfBoundsException {

        Type genType = clazz.getGenericSuperclass();

        if (!(genType instanceof ParameterizedType)) {
            return Object.class;
        }

        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

        if (index >= params.length || index < 0) {
            return Object.class;
        }
        if (!(params[index] instanceof Class)) {
            return Object.class;
        }
        return (Class) params[index];
    }
}
