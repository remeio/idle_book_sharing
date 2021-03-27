package com.xumengqi.reme.api.book.response;

import com.xumengqi.reme.api.book.dto.BookDTO;
import com.xumengqi.reme.base.BaseResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author xumengqi
 * @date 2021/3/27 15:15
 */
@Getter
@Setter
public class GetBookListByUserIdResponse extends BaseResponse {
    @ApiModelProperty("书籍列表")
    private List<BookDTO> bookDTOList;
}
