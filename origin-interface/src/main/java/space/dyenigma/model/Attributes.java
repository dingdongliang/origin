package space.dyenigma.model;

import space.dyenigma.entity.BaseDomain;

/**
 * origin/space.dyenigma.model
 *
 * @Description: 状态属性, TreeModel模型中调用
 * @Author: dingdongliang
 * @Date: 2015年9月23日 上午11:17:19
 */
public class Attributes extends BaseDomain {
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
