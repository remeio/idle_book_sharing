package com.xumengqi.reme.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class ShareRecord implements Serializable {
    /**
     * 共享记录ID
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 订单号
     *
     * @mbg.generated
     */
    private String orderNo;

    /**
     * 书籍ID
     *
     * @mbg.generated
     */
    private Long bookId;

    /**
     * 共享者ID
     *
     * @mbg.generated
     */
    private Long shareUserId;

    /**
     * 借阅者ID
     *
     * @mbg.generated
     */
    private Long borrowUserId;

    /**
     * 共享记录状态【1：已下单，2：借阅中，3：已归还，4：逾期归还，5：下单后取消，6：书籍丢失或严重受损，7：书籍超时严重不归还】
     *
     * @mbg.generated
     */
    private Integer recordStatus;

    /**
     * 评分【1，1.5，2，2.5，3，3.5，4，4.5，5】
     *
     * @mbg.generated
     */
    private Double score;

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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getShareUserId() {
        return shareUserId;
    }

    public void setShareUserId(Long shareUserId) {
        this.shareUserId = shareUserId;
    }

    public Long getBorrowUserId() {
        return borrowUserId;
    }

    public void setBorrowUserId(Long borrowUserId) {
        this.borrowUserId = borrowUserId;
    }

    public Integer getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Integer recordStatus) {
        this.recordStatus = recordStatus;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
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
        sb.append(", orderNo=").append(orderNo);
        sb.append(", bookId=").append(bookId);
        sb.append(", shareUserId=").append(shareUserId);
        sb.append(", borrowUserId=").append(borrowUserId);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", score=").append(score);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}