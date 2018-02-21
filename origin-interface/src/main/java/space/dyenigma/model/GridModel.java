package space.dyenigma.model;

import java.util.ArrayList;
import java.util.List;

/**
 * origin/space.dyenigma.model
 *
 * @Description: 状态属性, TreeModel模型中调用
 * @Author: dingdongliang
 * @Date: 2015年9月23日 上午11:17:19
 */
public class GridModel {
    private List rows = new ArrayList();
    private Integer total = 0;

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
