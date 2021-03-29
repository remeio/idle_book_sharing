package com.xumengqi.reme.api.book.request;

import com.xumengqi.reme.base.BaseRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * @author xumengqi
 * @date 2021/3/29 22:28
 */
@Getter
@Setter
public class DeleteFromBookcaseRequest extends BaseRequest {
    @ApiModelProperty("书箱记录ID")
    @NotNull
    private Long bookcaseId;
}
