package space.dyenigma.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * origin/space.dyenigma.core
 *
 * @Description: 响应码枚举，参考HTTP状态码的语义
 * @Author: dingdongliang
 * @Date: 2017/6/23 15:42
 */
public enum ResultCode {

    FAIL(400, "常见故障"),

    SUCCESS(200, "成功"),

    ERROR_PIC_FILE(3, "非法图片文件"),

    ERROR_PIC_UPLOAD(4, "图片上传失败"),

    ERROR_RECORD_NOT_FOUND(5, "没有找到对应的数据"),

    ERROR_MAX_PAGE_SIZE(6, "请求记录数超出每次请求最大允许值"),

    ERROR_CREATE_FAILED(7, "新增失败"),

    ERROR_UPDATE_FAILED(8, "修改失败"),

    ERROR_DELETE_FAILED(9, "删除失败"),

    ERROR_SEARCH_FAILED(10, "查询失败"),

    ERROR_COUNT_FAILED(11, "查询数据总数失败"),

    ERROR_STRING_TO_OBJ(12, "字符串转JAVA对象失败"),

    ERROR_INVALID_ARGUMENT(13, "参数不合法"),

    ERROR_UPDATE_NOT_ALLOWED(14, "更新失败：%S"),

    ERROR_DUPLICATED_DATA(15, "数据已存在"),

    ERROR_UNKNOWN_DATABASE_OPERATION(16, "未知数据库操作失败，请联系管理员解决"),

    ERROR_COLUMN_UNIQUE(17, "字段S%违反唯一约束性条件"),

    ERROR_FILE_DOWNLOAD(18, "文件下载失败"),

    ERROR_FILE_UPLOAD(19, "文件上传失败"),

    HTTP_STATUS_BAD_REQUEST(400, "错误的请求"),

    HTTP_STATUS_UNAUTHORIZED(401, "未经授权"),

    HTTP_STATUS_PAYMENT_REQUIRED(402, "PAYMENT REQUIRED"),

    HTTP_STATUS_FORBIDDEN(403, "禁止操作"),

    HTTP_STATUS_NOT_FOUND(404, "没有找到相关资源"),

    HTTP_STATUS_METHOD_NOT_ALLOWED(405, "方法不允许"),

    HTTP_STATUS_NOT_ACCEPTABLE(406, "不被接受的"),

    HTTP_STATUS_PROXY_AUTHENTICATION_REQUIRED(407, "需要代理验证"),

    HTTP_STATUS_REQUEST_TIMEOUT(408, "请求超时"),

    HTTP_STATUS_CONFLICT(409, "冲突"),

    HTTP_STATUS_GONE(410, "GONE"),

    HTTP_STATUS_LENGTH_REQUIRED(411, "需要长度"),

    HTTP_STATUS_PRECONDITION_FAILED(412, "前提条件失败"),

    HTTP_STATUS_PAYLOAD_TOO_LARGE(413, "有效载荷太大"),

    HTTP_STATUS_URI_TOO_LONG(414, "uri超时"),

    HTTP_STATUS_UNSUPPORTED_MEDIA_TYPE(415, "媒体类型不受支持"),

    HTTP_STATUS_REQUESTED_RANGE_NOT_SATISFIABLE(416, "不在请求范围内"),

    HTTP_STATUS_EXPECTATION_FAILED(417, "失败的期望"),

    HTTP_STATUS_IM_A_TEAPOT(418, "我是一个蜜罐"),

    HTTP_STATUS_UNPROCESSABLE_ENTITY(422, "不可处理的实体"),

    HTTP_STATUS_LOCKED(423, "被锁定"),

    HTTP_STATUS_FAILED_DEPENDENCY(424, "依赖关系不足"),

    HTTP_STATUS_UPGRADE_REQUIRED(426, "需要升级"),

    HTTP_STATUS_PRECONDITION_REQUIRED(428, "前提条件"),

    HTTP_STATUS_TOO_MANY_REQUESTS(429, "请求堵塞"),

    HTTP_STATUS_REQUEST_HEADER_FIELDS_TOO_LARGE(431, "请求头超长"),

    HTTP_STATUS_INTERNAL_SERVER_ERROR(500, "系统错误"),

    HTTP_STATUS_NOT_IMPLEMENTED(501, "未实现"),

    HTTP_STATUS_BAD_GATEWAY(502, "错误的网关"),

    HTTP_STATUS_SERVICE_UNAVAILABLE(503, "暂停服务"),

    HTTP_STATUS_GATEWAY_TIMEOUT(504, "网关超时"),

    HTTP_STATUS_HTTP_VERSION_NOT_SUPPORTED(505, "http版本不支持"),

    HTTP_STATUS_VARIANT_ALSO_NEGOTIATES(506, "VARIANT ALSO NEGOTIATES"),

    HTTP_STATUS_INSUFFICIENT_STORAGE(507, "存储空间不足"),

    HTTP_STATUS_LOOP_DETECTED(508, "循环检测"),

    HTTP_STATUS_BANDWIDTH_LIMIT_EXCEEDED(509, "超出带宽限制"),

    HTTP_STATUS_NOT_EXTENDED(510, "不延长"),

    HTTP_STATUS_NETWORK_AUTHENTICATION_REQUIRED(511, "需要网络验证"),

    EXCEPTION(800, "例外"),

    INVALID_PARAM(801, "无效参数"),

    INVALID_PRIVI(802, "无效PRIVI"),

    NO_LOGIN(1000, "没有登录"),

    CONFIG_ERROR(1001, "参数配置表错误"),

    USER_EXIST(1002, "用户名已存在"),

    USERPWD_NOT_EXIST(1003, "用户名不存在或者密码错误");

    private static final Logger logger = LoggerFactory.getLogger(ResultCode.class);
    int code;
    String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static int getCode(String define) {
        try {
            return ResultCode.valueOf(define).code;
        } catch (IllegalArgumentException e) {
            logger.error("undefined error code: {}", define);
            return FAIL.getErrorCode();
        }
    }

    public static String getMsg(String define) {
        try {
            return ResultCode.valueOf(define).msg;
        } catch (IllegalArgumentException e) {
            logger.error("undefined error code: {}", define);
            return FAIL.getErrorMsg();
        }

    }

    public static String getMsg(int code) {
        for (ResultCode err : ResultCode.values()) {
            if (err.code == code) {
                return err.msg;
            }
        }
        return "errorCode not defined ";
    }

    public int getErrorCode() {
        return code;
    }

    public String getErrorMsg() {
        return msg;
    }
}
