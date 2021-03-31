package com.xumengqi.reme.api.book.response;

import com.xumengqi.reme.api.book.dto.BookDTO;
import com.xumengqi.reme.base.BaseRequest;
import com.xumengqi.reme.base.BaseResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author xumengqi
 * @date 2021/3/31 18:13
 */
@Getter
@Setter
public class GetTodayBookListResponse extends BaseResponse {
    @ApiModelProperty("书籍列表")
    private List<BookDTO> bookDTOList;
}
