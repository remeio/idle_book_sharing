package com.xumengqi.reme.api.book.dto;

import com.xumengqi.reme.base.BaseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author xumengqi
 * @date 2021/3/25 20:20
 */
@Getter
@Setter
public class BookDTO extends BaseDTO {
    /**
     * 书籍ID
     */
    private Long id;

    /**
     * 书籍名称
     */
    private String bookName;

    /**
     * 书籍ISBN
     */
    private String bookIsbn;

    /**
     * 书籍描述
     */
    private String bookDescription;

    /**
     * 书籍借出最大周期
     */
    private Integer bookMaxPeriod;

    /**
     * 书籍所需押金
     */
    private Long bookDeposit;

    /**
     * 书籍图片URL
     */
    private String bookImageUrl;

    /**
     * 书籍分类ID
     */
    private Long bookCatalogId;

    /**
     * 学校ID
     */
    private Long schoolId;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 书籍状态【1：可借阅，2.已下单，3：借阅中，4：已下架】
     */
    private Integer bookStatus;

    /**
     * 学校名称
     */
    private String schoolName;

    /**
     * 共享者名称
     */
    private String userFullName;

    /**
     * 书籍分类名称
     */
    private String bookCatalogName;

    /**
     * 创建时间
     */
    private Date gmtCreate;
}
