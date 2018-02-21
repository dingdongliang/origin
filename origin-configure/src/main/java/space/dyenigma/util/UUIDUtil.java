package space.dyenigma.util;

import java.util.UUID;

/**
 * origin/space.dyenigma.util
 *
 * @Description: 生成数据库主键的方法
 * @Author: dingdongliang
 * @Date: 2016/4/21 8:22
 */
public class UUIDUtil {
    /**
     * @param
     * @return java.lang.String
     * @Description : 获得一个UUID
     * @author dingdongliang
     * @date 2018/2/20 19:43
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * @param number
     * @return java.lang.String[]
     * @Description : 获得指定数量的UUID
     * @author dingdongliang
     * @date 2018/2/20 19:43
     */
    public static String[] getUUID(int number) {
        if (number < 1) {
            return null;
        }
        String[] ss = new String[number];
        for (int i = 0; i < number; i++) {
            ss[i] = getUUID();
        }
        return ss;
    }
}
