package com.xumengqi.reme.api.book.request;

import com.xumengqi.reme.base.BaseRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * @author xumengqi
 * @date 2021/3/28 14:00
 */
@Getter
@Setter
public class GetShareLogListByShareRecordIdRequest extends BaseRequest {

    @ApiModelProperty("共享记录ID")
    @NotNull
    private Long shareRecordId;
}
