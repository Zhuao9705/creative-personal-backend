package exception;


import lombok.Getter;
import org.slf4j.event.Level;

/**
 * @author: zhuao
*/
@Getter
public enum BackendExceptionType {

    /**
     * 参数校验错误
     */
    PARAMETER_VERIFY_FAILURE(101001, "参数校验错误"),

    /**
     * account
     */
    USER_NOT_LOGIN(401, "用户未登录"),
    ROLE_NOT_MATCH(403, "角色没有权限"),
    PERMISSION_DENIED(105002, "没有操作权限"),
    PHONE_IS_EXIST(105003, "手机号已存在"),
    ADD_ACCOUNT_IS_FAILED(105004, "添加账户失败"),
    USER_NOT_REGISTER(105005, "用户未注册"),

    /**
     * redis
     */
    ACQUIRE_LOCK_FAILURE(106001),

    ACCESS_TOO_BUSY(106003, "访问过于频繁,请稍后再试"),
    UNKNOWN_ERROR(109999),
    ;

    final int code;
    String message = "服务异常";
    final Level level = Level.WARN;

    BackendExceptionType(int code) {
        this.code = code;
    }

    BackendExceptionType(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
