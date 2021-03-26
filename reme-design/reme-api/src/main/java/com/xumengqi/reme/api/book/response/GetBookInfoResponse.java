package com.xumengqi.reme.api.book.response;

import com.xumengqi.reme.api.book.dto.BookDTO;
import com.xumengqi.reme.base.BaseResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author xumengqi
 * @date 2021/3/26 14:11
 */
@Getter
@Setter
public class GetBookInfoResponse extends BaseResponse {

    @ApiModelProperty("书籍信息")
    private BookDTO bookDTO;
}
