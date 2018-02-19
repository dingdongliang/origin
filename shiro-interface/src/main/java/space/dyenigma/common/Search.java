package space.dyenigma.common;

import java.io.Serializable;

/**
 * origin/space.dyenigma.common
 *
 * @Description:
 * @Author: dingdongliang
 * @Date: 2018/2/14 18:58
 */
public class Search implements Serializable {

    private static final long serialVersionUID = 1L;
    private String value;
    private boolean regex;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isRegex() {
        return regex;
    }

    public void setRegex(boolean regex) {
        this.regex = regex;
    }

}