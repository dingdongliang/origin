package space.dyenigma.core;

import com.alibaba.fastjson.JSON;

/**
 * origin/space.dyenigma.core
 *
 * @Description: 统一API响应结果封装
 * @Author: dingdongliang
 * @Date: 2017/6/23 15:42
 */
public class Result {
    private int code;
    private String title;
    private String message;
    private Object data;

    public Result setCode(ResultCode resultCode) {
        this.code = resultCode.code;
        return this;
    }

    public int getCode() {
        return code;
    }

    public Result setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public Result setData(Object data) {
        this.data = data;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Result setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
