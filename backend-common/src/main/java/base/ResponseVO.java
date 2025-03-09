package base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * author: zhuao
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseVO<T> {

    @Builder.Default
    private Integer code = 200;

    @Builder.Default
    private String message = "success";

    private T result;
}
