package com.xumengqi.reme.base;

/**
 * @author xumengqi
 * @date 2021/1/31 13:56
 */
public class PageRequest extends BaseRequest {
    private int pageSize;

    private int pageNum;

    private String orderBy;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}
