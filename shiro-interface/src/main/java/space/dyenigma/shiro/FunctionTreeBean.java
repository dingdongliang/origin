package space.dyenigma.shiro;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * origin/space.dyenigma.shiro
 *
 * @Description: 展示功能Tree时使用
 * @Author: dingdongliang
 * @Date: 2018/2/14 19:15
 */
@Slf4j
@Data
public class FunctionTreeBean {

    private Integer id;
    private Integer parentId;
    private String name;
    private boolean checked = false;
    private boolean open = true;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }
}