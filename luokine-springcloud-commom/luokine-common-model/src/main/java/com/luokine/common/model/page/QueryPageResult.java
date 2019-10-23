/**
 * 
 */
package com.luokine.common.model.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 查询结果对象
 */
@Data
@ApiModel(description = "分页请求结果")
public class QueryPageResult<R> implements java.io.Serializable {

    /**
     * Instantiates a new Query page result.
     */
    public QueryPageResult() {
        super();
    }

    /**
     * Instantiates a new Query page result.
     *
     * @param dataList   the data list
     * @param totalCount the total count
     */
    public QueryPageResult(List<R> dataList, long totalCount) {
        super();
        this.totalCount = totalCount;
        this.dataList = dataList;
    }

    public QueryPageResult(long totalCount, List<R> dataList, boolean hasNextPage, Integer totalPages, int nextPage) {
        this.totalCount = totalCount;
        this.dataList = dataList;
        this.hasNextPage = hasNextPage;
        this.totalPages = totalPages;
        this.nextPage = nextPage;
    }

    /**
     * 总记录数:total count
     */
    @ApiModelProperty(value = "总记录数")
    private long totalCount = 0L;

    /**
     * 结果列表
     */
    @ApiModelProperty(value = "数据列表")
    private List<R> dataList;
    /**
     * The Has next page.
     */
    @ApiModelProperty(value = "是否有下一页")
    private boolean hasNextPage;
    /**
     * The Total pages.
     */
    @ApiModelProperty(value = "总页数")
    private Integer totalPages;
    /**
     * The Next page.
     */
    @ApiModelProperty(value = "下一页页码")
    private int nextPage;

}
