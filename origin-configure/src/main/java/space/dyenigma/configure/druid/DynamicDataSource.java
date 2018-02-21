package space.dyenigma.configure.druid;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * origin/space.dyenigma.configure.druid
 *
 * @Description: 动态数据源
 * @Author: dingdongliang
 * @Date: 2017/7/25 10:25
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.getDataSourceType();
    }
}
