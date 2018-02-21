package space.dyenigma.core;

/**
 * origin/space.dyenigma.core
 *
 * @Description: 服务（业务）异常如“ 账号或密码错误 ”，该异常只做INFO级别的日志记录
 * @Author: dingdongliang
 * @Date: 2017/6/23 15:42
 */
public class ServiceException extends RuntimeException {
    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
