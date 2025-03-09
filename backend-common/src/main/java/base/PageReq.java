package base;

import lombok.Data;


/**
 * @author zhuao
 * @description: 分页参数
 */
@Data
public class PageReq {
    /**
     * 页号，默认1
     */
    private int pageIndex = 1;

    /**
     * 每页大小，默认10
     */
    private int pageSize = 10;

}
