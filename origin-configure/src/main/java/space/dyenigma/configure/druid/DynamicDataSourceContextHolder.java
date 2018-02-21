package space.dyenigma.configure.druid;

import java.util.ArrayList;
import java.util.List;

/**
 * origin/space.dyenigma.configure.druid
 *
 * @Description: 动态数据源生成
 * @Author: dingdongliang
 * @Date: 2017/7/25 10:29
 */
public class DynamicDataSourceContextHolder {
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();
    public static List<String> dataSourceIds = new ArrayList<>();

    public static void setDataSourceType(String dataSourceType) {
        contextHolder.set(dataSourceType);
    }

    public static String getDataSourceType() {
        return contextHolder.get();
    }

    public static void clearDataSourceType() {
        contextHolder.remove();
    }

    /**
     * @param dataSourceId
     * @return boolean
     * @Description : 判断指定DataSrouce当前是否存在
     * @author dingdongliang
     * @date 2018/2/20 17:54
     */
    public static boolean containsDataSource(String dataSourceId) {
        return dataSourceIds.contains(dataSourceId);
    }
}
