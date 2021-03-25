package com.xumengqi.reme.api.book.response;

import com.xumengqi.reme.api.book.dto.BookCatalogDTO;
import com.xumengqi.reme.base.BaseResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author xumengqi
 * @date 2021/3/25 14:18
 */
@Getter
@Setter
public class GetBookCatalogListResponse extends BaseResponse {
    @ApiModelProperty("书籍分类列表")
    List<BookCatalogDTO> bookCatalogDTOList;
}
