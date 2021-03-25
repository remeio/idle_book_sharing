package com.xumengqi.reme.api.book.request;

import com.xumengqi.reme.base.BaseRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author xumengqi
 * @date 2021/3/25 19:51
 */
@Getter
@Setter
public class GetBookListByBookCatalogRequest extends BaseRequest {
    /**
     * 书籍分类ID
     */
    @ApiModelProperty("书籍分类ID")
    private Long bookCatalogId;
}
