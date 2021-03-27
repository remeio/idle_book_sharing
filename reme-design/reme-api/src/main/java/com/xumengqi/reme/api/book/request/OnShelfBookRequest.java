package com.xumengqi.reme.api.book.request;

import com.xumengqi.reme.base.BaseRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * @author xumengqi
 * @date 2021/3/27 17:02
 */
@Getter
@Setter
public class OnShelfBookRequest extends BaseRequest {
    @ApiModelProperty("书籍ID")
    @NotNull
    private Long bookId;
}
