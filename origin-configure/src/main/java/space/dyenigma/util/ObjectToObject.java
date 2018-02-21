package space.dyenigma.util;

import java.lang.reflect.Field;

/**
 * origin/space.dyenigma.util
 *
 * @Description:
 * @Author: dingdongliang
 * @Date: 2018/2/14 19:07
 */
public class ObjectToObject {
    public static <T> void mergeObject(T origin, T destination) {
        if (origin == null || destination == null)
            return;
        if (!origin.getClass().equals(destination.getClass()))
            return;

        Field[] fields = origin.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            try {
                fields[i].setAccessible(true);
                Object value = fields[i].get(origin);
                if (null != value) {
                    fields[i].set(destination, value);
                }
                fields[i].setAccessible(false);
            } catch (Exception e) {
            }
        }
    }
}
