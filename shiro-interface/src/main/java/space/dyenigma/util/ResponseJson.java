package space.dyenigma.util;

import lombok.Data;

/**
 * origin/space.dyenigma.util
 *
 * @Description:
 * @Author: dingdongliang
 * @Date: 2018/2/14 19:08
 */
@Data
public class ResponseJson {

    public String msg;
    public String url;
    public String returnStr;
    public boolean success = true;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getReturnStr() {
        return returnStr;
    }

    public void setReturnStr(String returnStr) {
        this.returnStr = returnStr;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}