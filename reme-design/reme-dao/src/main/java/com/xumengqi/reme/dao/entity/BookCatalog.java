package com.xumengqi.reme.dao.entity;

import java.io.Serializable;

public class BookCatalog implements Serializable {
    /**
     * 书籍分类ID
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 书籍分类名称
     *
     * @mbg.generated
     */
    private String bookCatalogName;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookCatalogName() {
        return bookCatalogName;
    }

    public void setBookCatalogName(String bookCatalogName) {
        this.bookCatalogName = bookCatalogName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", bookCatalogName=").append(bookCatalogName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}