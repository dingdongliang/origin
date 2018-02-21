package space.dyenigma.model;

import java.util.List;

/**
 * origin/space.dyenigma.model
 *
 * @Description: 无尽级菜单模型
 * @Author: dingdongliang
 * @Date: 2015年9月23日 上午11:17:19
 */
public class MultiMenu {
    private String id;
    private String pid;
    private String state;
    private String name;
    private String status;
    private String sort;
    private String path;
    private String pName;
    private String myid;
    private String description;
    private String iconCls;
    private String type;
    private String ifUsed;
    private List<MultiMenu> children; //必须是children

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getMyid() {
        return myid;
    }

    public void setMyid(String myid) {
        this.myid = myid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIfUsed() {
        return ifUsed;
    }

    public void setIfUsed(String ifUsed) {
        this.ifUsed = ifUsed;
    }

    public List<MultiMenu> getChildren() {
        return children;
    }

    public void setChildren(List<MultiMenu> children) {
        this.children = children;
    }
}
