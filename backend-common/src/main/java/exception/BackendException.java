package exception;


import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author: zhuao
*/
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
public class BackendException extends RuntimeException {

    @Builder.Default
    private BackendExceptionType exceptionType = BackendExceptionType.UNKNOWN_ERROR;

    public BackendException(String message, BackendExceptionType exceptionType) {
        super(composeMessage(exceptionType, message));
        this.exceptionType = exceptionType;
    }

    public BackendException(BackendExceptionType exceptionType) {
        this.exceptionType = exceptionType;
    }

    public BackendException(String message) {
        super(composeMessage(BackendExceptionType.UNKNOWN_ERROR, message));
    }

    static String composeMessage(BackendExceptionType exceptionType, String message) {
        return "[" + exceptionType + "]: " + message;
    }
}
