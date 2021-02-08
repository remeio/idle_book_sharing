package com.xumengqi.reme.base;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @author xumengqi
 * @date 2021/1/31 13:56
 */
public class PageRequest extends BaseRequest {
    @ApiModelProperty("显示条数")
    @Min(value = 1, message = "{PageRequest.pageSize.Min}")
    @Max(value = Integer.MAX_VALUE, message = "{PageRequest.pageSize.Max}")
    private Integer pageSize;

    @ApiModelProperty("当前页")
    @Min(value = 1, message = "{PageRequest.pageNum.Min}")
    @Max(value = Integer.MAX_VALUE, message = "{PageRequest.pageNum.Max}")
    private Integer pageNum;

    @ApiModelProperty("排序")
    private String orderBy;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}
