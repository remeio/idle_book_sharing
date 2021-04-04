package com.xumengqi.reme.as.util.recommend;

import java.util.Objects;

/**
 * @author xumengqi
 * @date 2021/4/3 21:20
 */
public class BookSample {
    private Long userId;

    private Long bookCatalogId;

    private Long count;

    public BookSample(Long userId, Long bookCatalogId, Long count) {
        this.userId = userId;
        this.bookCatalogId = bookCatalogId;
        this.count = count;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookCatalogId() {
        return bookCatalogId;
    }

    public void setBookCatalogId(Long bookCatalogId) {
        this.bookCatalogId = bookCatalogId;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        BookSample that = (BookSample) o;
        return Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

    @Override
    public String toString() {
        return "DataSource{" +
                "userId=" + userId +
                ", bookCatalogId=" + bookCatalogId +
                ", count=" + count +
                '}';
    }
}
