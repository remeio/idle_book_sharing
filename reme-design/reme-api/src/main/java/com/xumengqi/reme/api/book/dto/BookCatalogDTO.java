package com.xumengqi.reme.api.book.dto;

import com.xumengqi.reme.base.BaseDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @author xumengqi
 * @date 2021/3/25 14:26
 */
@Getter
@Setter
public class BookCatalogDTO extends BaseDTO {
    /**
     * 书籍分类ID
     */
    private Long id;

    /**
     * 书籍分类名称
     */
    private String bookCatalogName;
}
