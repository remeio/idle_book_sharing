package com.xumengqi.reme.base;

/**
 * @author xumengqi
 * @date 2021/1/31 13:58
 */
public class PageResponse extends BaseResponse {
    private int pageSize;

    private int pageNum;

    private long total;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

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
}
