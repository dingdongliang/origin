package space.dyenigma.common;

import java.io.Serializable;
import java.util.List;

/**
 * origin/space.dyenigma.common
 *
 * @Description:
 * @Author: dingdongliang
 * @Date: 2018/2/14 18:57
 */
public class PaginationResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    public PaginationResult() {

    }

    private int draw;

    /**
     * 经过查询条件查询的总个数.
     * (一般情况下 默认和recordsTotal 保持一样就可以)
     */
    private long recordsFiltered;

    /**
     * 查询的总个数
     */
    private long recordsTotal;

    /**
     * 查询某页返回的数据.
     */
    private List<T> data;

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public long getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

}
