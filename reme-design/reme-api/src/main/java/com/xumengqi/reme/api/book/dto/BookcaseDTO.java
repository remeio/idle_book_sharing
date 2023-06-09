package com.xumengqi.reme.api.book.dto;

import com.xumengqi.reme.base.BaseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author xumengqi
 * @date 2021/3/29 22:31
 */
@Getter
@Setter
public class BookcaseDTO extends BaseDTO {
    /**
     * 主键
     */
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 书籍ID
     */
    private Long bookId;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    // CUSTOM
    /**
     * 书籍
     */
    private BookDTO bookDTO;
}
