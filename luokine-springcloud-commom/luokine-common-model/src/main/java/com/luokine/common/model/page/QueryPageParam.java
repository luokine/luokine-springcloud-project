package com.luokine.common.model.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 分页查询对象
 *
 */
@Data
@ApiModel(description = "分页请求参数")
public class QueryPageParam implements java.io.Serializable {
    /**
     * The Current page.
     */
    @NotNull(message = "当前页码不能为空")
    @Min(value = 1, message = "当前页不能小于1")
    @ApiModelProperty(value = "当前页（默认第1页）", required = true, example = "1")
    private Integer currentPage = 1;
    /**
     * The Page size.
     */
    @NotNull(message = "页码大小不能为空")
    @Min(value = 1, message = "页码大小不能小于1")
    @ApiModelProperty(value = "页面大小（默认：10）", required = true, example = "10")
    private Integer pageSize = 10;
}
