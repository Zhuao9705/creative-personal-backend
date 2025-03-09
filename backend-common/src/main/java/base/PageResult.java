package base;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


public class PageResult<T>{

    @Getter
    @Setter
    private List<T> data;
    /**
     * 查询到的结果总数
     */
    @Getter
    @Setter
    private long totalRecords;

    /**
     * 总页数
     */
    @Getter
    @Setter
    private long totalPages;

    /**
     * 当前页码
     */
    @Getter
    @Setter
    private int pageNum;

    /**
     * 每页条数
     */
    @Getter
    @Setter
    private int pageSize;

    /**
     * 默认单页记录数
     */
    private static final int DEFAULT_PAGE_SIZE = 10;

    /**
     * 默认当前页
     */
    private static final int DEFAULT_CURRENT_PAGE = 1;

}
