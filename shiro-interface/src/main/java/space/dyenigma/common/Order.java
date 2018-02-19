package space.dyenigma.common;

import java.io.Serializable;

/**
 * origin/space.dyenigma.common
 *
 * @Description:
 * @Author: dingdongliang
 * @Date: 2018/2/14 18:55
 */
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    private int column;//排序字段属性编号0，1，2，，，
    private String columnName;//排序字段属性名称
    private String dir;

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }
}
