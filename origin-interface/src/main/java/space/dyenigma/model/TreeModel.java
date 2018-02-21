/**
 * Title: TreeModel.java
 * Package space.dyenigma.model
 * author dingdongliang
 * date 2015年9月23日 上午11:16:46
 * version V1.0
 * Copyright (c) 2015,dyenigma@163.com All Rights Reserved.
 */

package space.dyenigma.model;

import space.dyenigma.entity.BaseDomain;

import java.util.List;

/**
 * origin/space.dyenigma.model
 *
 * @Description: 树展示模型
 * @Author: dingdongliang
 * @Date: 2015年9月23日 上午11:17:19
 */
public class TreeModel extends BaseDomain {
    private String id;
    private String pid;
    private String text;
    private String iconCls;
    private String state;
    private List<TreeModel> children;

    public List<TreeModel> getChildren() {
        return children;
    }

    public void setChildren(List<TreeModel> children) {
        this.children = children;
    }

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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
