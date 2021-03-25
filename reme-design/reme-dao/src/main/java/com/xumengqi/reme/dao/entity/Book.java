package com.xumengqi.reme.dao.entity;

import java.io.Serializable;

public class Book implements Serializable {
    /**
     * 书籍ID
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 书籍名称
     *
     * @mbg.generated
     */
    private String bookName;

    /**
     * 书籍ISBN
     *
     * @mbg.generated
     */
    private String bookIsbn;

    /**
     * 书籍描述
     *
     * @mbg.generated
     */
    private String bookDescription;

    /**
     * 书籍借出最大周期
     *
     * @mbg.generated
     */
    private Integer bookMaxPeriod;

    /**
     * 书籍所需押金
     *
     * @mbg.generated
     */
    private Integer bookDeposit;

    /**
     * 书籍图片URL
     *
     * @mbg.generated
     */
    private String bookImageUrl;

    /**
     * 书籍分类ID
     *
     * @mbg.generated
     */
    private Long bookCatalogId;

    /**
     * 学校ID
     *
     * @mbg.generated
     */
    private Long schoolId;

    /**
     * 用户ID
     *
     * @mbg.generated
     */
    private Long userId;

    /**
     * 是否已下架
     *
     * @mbg.generated
     */
    private Integer isDelete;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public Integer getBookMaxPeriod() {
        return bookMaxPeriod;
    }

    public void setBookMaxPeriod(Integer bookMaxPeriod) {
        this.bookMaxPeriod = bookMaxPeriod;
    }

    public Integer getBookDeposit() {
        return bookDeposit;
    }

    public void setBookDeposit(Integer bookDeposit) {
        this.bookDeposit = bookDeposit;
    }

    public String getBookImageUrl() {
        return bookImageUrl;
    }

    public void setBookImageUrl(String bookImageUrl) {
        this.bookImageUrl = bookImageUrl;
    }

    public Long getBookCatalogId() {
        return bookCatalogId;
    }

    public void setBookCatalogId(Long bookCatalogId) {
        this.bookCatalogId = bookCatalogId;
    }

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", bookName=").append(bookName);
        sb.append(", bookIsbn=").append(bookIsbn);
        sb.append(", bookDescription=").append(bookDescription);
        sb.append(", bookMaxPeriod=").append(bookMaxPeriod);
        sb.append(", bookDeposit=").append(bookDeposit);
        sb.append(", bookImageUrl=").append(bookImageUrl);
        sb.append(", bookCatalogId=").append(bookCatalogId);
        sb.append(", schoolId=").append(schoolId);
        sb.append(", userId=").append(userId);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}