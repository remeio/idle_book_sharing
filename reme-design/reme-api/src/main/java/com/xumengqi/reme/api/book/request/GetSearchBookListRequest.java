package com.xumengqi.reme.api.book.request;

import com.xumengqi.reme.base.BaseRequest;
import com.xumengqi.reme.base.validation.ChineseLength;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author xumengqi
 * @date 2021/4/2 13:02
 */
@Getter
@Setter
public class GetSearchBookListRequest extends BaseRequest {
    @ApiModelProperty("关键字")
    @ChineseLength(min = 1, max = 50)
    private String keyword;
}
