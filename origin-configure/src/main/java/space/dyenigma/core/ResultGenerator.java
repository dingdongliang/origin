package space.dyenigma.core;

/**
 * origin/space.dyenigma.core
 *
 * @Description: 响应结果生成工具
 * @Author: dingdongliang
 * @Date: 2017/6/23 15:42
 */
public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    public static Result genSuccessResult() {
        return new Result().setCode(ResultCode.SUCCESS).setTitle(ResultCode.getMsg(200))
                .setMessage(DEFAULT_SUCCESS_MESSAGE);
    }

    public static Result genSuccessResult(Object data) {
        return new Result().setCode(ResultCode.SUCCESS).setTitle(ResultCode.getMsg(200))
                .setMessage(DEFAULT_SUCCESS_MESSAGE).setData(data);
    }

    public static Result genFailResult(String message) {
        return new Result().setCode(ResultCode.FAIL).setTitle(ResultCode.getMsg(400))
                .setMessage(message);
    }
}
