package com.xumengqi.reme.dao.entity;

import java.io.Serializable;
import java.util.Date;

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
    private Long bookDeposit;

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
     * 书籍状态【1：空闲，2：受理中，3：异常，4：已下架，5：已删除】
     *
     * @mbg.generated
     */
    private Integer bookStatus;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private Date gmtCreate;

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

    public Long getBookDeposit() {
        return bookDeposit;
    }

    public void setBookDeposit(Long bookDeposit) {
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

    public Integer getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(Integer bookStatus) {
        this.bookStatus = bookStatus;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
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
        sb.append(", bookStatus=").append(bookStatus);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}