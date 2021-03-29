package com.xumengqi.reme.api.book.request;

import com.xumengqi.reme.base.BaseRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * @author xumengqi
 * @date 2021/3/29 22:29
 */
@Getter
@Setter
public class GetBookcaseListByUserIdRequest extends BaseRequest {
    @ApiModelProperty("用户ID")
    @NotNull
    private Long userId;
}
