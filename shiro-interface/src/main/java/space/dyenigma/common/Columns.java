package space.dyenigma.common;

import java.io.Serializable;

/**
 * origin/space.dyenigma.common
 *
 * @Description:
 * @Author: dingdongliang
 * @Date: 2018/2/14 18:48
 */
public class Columns implements Serializable {
    private static final long serialVersionUID = 1L;
    private String data;
    private boolean searchable;

    public boolean isSearchable() {
        return searchable;
    }

    public void setSearchable(boolean searchable) {
        this.searchable = searchable;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
