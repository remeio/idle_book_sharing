package com.xumengqi.reme.api.book.response;

import com.xumengqi.reme.api.book.dto.BookcaseDTO;
import com.xumengqi.reme.base.BaseRequest;
import com.xumengqi.reme.base.BaseResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author xumengqi
 * @date 2021/3/29 22:29
 */
@Getter
@Setter
public class GetBookcaseListByUserIdResponse extends BaseResponse {
    private List<BookcaseDTO> bookcaseDTOList;
}
