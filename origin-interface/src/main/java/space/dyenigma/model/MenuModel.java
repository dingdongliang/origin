package space.dyenigma.model;

import space.dyenigma.entity.BaseDomain;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.ArrayList;
import java.util.List;

/**
 * origin/space.dyenigma.model
 *
 * @Description: 菜单模型类
 * @Author: dingdongliang
 * @Date: 2015年9月23日 上午11:17:19
 */
public class MenuModel extends BaseDomain {
    private String id;
    private String pid;
    private String name;
    private String iconCls;
    private String url;
    @JsonManagedReference
    private List<MenuModel> child = new ArrayList<MenuModel>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<MenuModel> getChild() {
        return child;
    }

    public void setChild(List<MenuModel> child) {
        this.child = child;
    }
}
