package com.xumengqi.reme.as.vo;

import com.xumengqi.reme.api.book.dto.BookDTO;
import com.xumengqi.reme.base.BaseVO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author xumengqi
 * @date 2021/3/29 22:45
 */
@Getter
@Setter
public class BookcaseVO extends BaseVO {
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
