package com.xumengqi.reme.base.util;

import com.github.pagehelper.IPage;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author xumengqi
 * @date 2021/1/31 00:13
 */
public class PageUtils<Param, Result> {

    public PageInfo<Result> page(PageParam param, Param query, Queryable<Param, Result> queryable) {
        return PageHelper.startPage(param).doSelectPageInfo(() -> queryable.listForPage(query));
    }

    public interface Queryable<Param, Result> {
        List<Result> listForPage(Param param);
    }

    public static class PageParam implements IPage {
        private Integer pageNum;

        private Integer pageSize;

        private String orderBy;

        public void setPageNum(Integer pageNum) {
            this.pageNum = pageNum;
        }

        public void setPageSize(Integer pageSize) {
            this.pageSize = pageSize;
        }

        public void setOrderBy(String orderBy) {
            this.orderBy = orderBy;
        }

        @Override
        public Integer getPageNum() {
            return pageNum;
        }

        @Override
        public Integer getPageSize() {
            return pageSize;
        }

        @Override
        public String getOrderBy() {
            return orderBy;
        }
    }
}