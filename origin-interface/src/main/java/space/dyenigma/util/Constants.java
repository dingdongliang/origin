package space.dyenigma.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import space.dyenigma.shiro.ShiroUser;

/**
 * origin/space.dyenigma.util
 *
 * @Description: 常用常量定义
 * @Author: dingdongliang
 * @Date: 2018/2/14 19:01
 */
public class Constants {
    //注册用户未审核
    public static String userStatus_0 = "0";
    //注册用户已审核
    public static String userStatus_1 = "1";
    //注册用户被锁定
    public static String userStatus_2 = "2";

    // 管理员在后台添加用户初始密码 111111
    public static String initPassword = "111111";
    //默认密码
    public static final String DEFAULT_PASSWORD = "111111";

    //redis cache 前缀
    public final static String REDIS_SHIRO_CACHE = "shiro-cache:";
    //redis session 前缀
    public final static String REDIS_SHIRO_SESSION = "shiro-session:";

    //正整数的正则表达式，用于StringUtil.compareRegex(regex,str)方法中
    public static final String REGEX_INTEGER = "^\\d+$";

    public static final String LOGIN_SESSION_DATANAME = "users";
    public static final String LOGIN_URL = "login";
    public static final String LOGIN_SUCCESS_URL = "index";
    public static final String LOGIN_LOGIN_OUT_URL = "loginout";
    public static final String LOGIN_MSG = "loginMsg";
    public static final String USERNAME_IS_NULL = "用户名为空!";
    public static final String LOGIN_IS_EXIST = "该用户已登录!";
    public static final String UNKNOWN_SESSION_EXCEPTION = "异常会话!";
    public static final String UNKNOWN_ACCOUNT_EXCEPTION = "账号错误!";
    public static final String INCORRECT_CREDENTIALS_EXCEPTION = "密码错误!";
    public static final String LOCKED_ACCOUNT_EXCEPTION = "账号已被锁定，请与系统管理员联系!";
    public static final String INCORRECT_CAPTCHA_EXCEPTION = "验证码错误!";
    public static final String AUTHENTICATION_EXCEPTION = "您没有授权!";
    public static final String UNKNOWN_EXCEPTION = "出现未知异常,请与系统管理员联系!";
    public static final String TREE_GRID_ADD_STATUS = "add";
    public static final String POST_DATA_SUCCESS = "操作成功!";
    public static final String POST_DATA_FAIL = "提交失败!";
    public static final String GET_SQL_LIKE = "%";

    //默认icon
    public static final String DEFAULT_ICON = "icon-default";
    public static final String COMPANY_ICON = "icon-company";
    public static final String DIVISION_ICON = "icon-flower";

    //默认分页，每页数据量
    public static final Integer DEFAULT_LENGTH = 10;

    //有效标记，E为有效，I为无效
    public static final String PERSISTENCE_STATUS = "E";
    public static final String PERSISTENCE_DELETE_STATUS = "I";

    public static final String SYSTEM_ADMINISTRATOR = "system";
    public static final String NULL_STRING = "";
    public static final String IS_DOT = ".";
    public static final String HQL_LIKE = "like";
    public static final String TEXT_TYPE_PLAIN = "text/plain";
    public static final String TEXT_TYPE_HTML = "text/html";
    public static final String CONTENT_DISPOSITION = "Content-Disposition";

    //菜单标记，O代表是操作，不能有子菜单，F为菜单
    public static final String PMSN_O = "O";
    public static final String PMSN_M = "M";

    //是否叶节点，open为是，closed为否
    public static final String TREE_STATUS_OPEN = "open";
    public static final String TREE_STATUS_CLOSED = "closed";

    public static final String IS_EXT_SUBMENU = " 菜单正在被角色使用或可能包含子菜单!";
    public static final String SHIRO_USER = "shiroUser";
    public static final String LOGS_INSERT = "insert:";
    public static final String LOGS_INSERT_TEXT = "插入:";
    public static final String LOGS_INSERT_NAME = "insertLogs";
    public static final String LOGS_UPDATE = "update:";
    public static final String LOGS_UPDATE_TEXT = "更新:";
    public static final String LOGS_UPDATE_NAME = "updateLogs";
    public static final String LOGS_DELETE = "delete:";
    public static final String LOGS_DELETE_TEXT = "删除:";
    public static final String LOGS_DELETE_NAME = "deleteLogs";
    public static final String LOGS_TB_NAME = "Log";

    public static final String FILE_SUFFIX_SQL = ".sql";
    public static final String FILE_SUFFIX_ZIP = ".zip";

    private Constants() {
    }

    /**
     * param @return 参数
     * return ShiroUser 返回类型
     * throws
     * Title: getCurrendUser
     * Description: 获取当前登录用户实体类
     */
    public static ShiroUser getCurrendUser() {
        Subject subject = SecurityUtils.getSubject();
        return (ShiroUser) subject.getSession().getAttribute(SHIRO_USER);
    }

}
