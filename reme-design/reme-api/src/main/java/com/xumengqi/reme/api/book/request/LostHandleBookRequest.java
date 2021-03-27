package com.xumengqi.reme.api.book.request;

import com.xumengqi.reme.base.BaseRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author xumengqi
 * @date 2021/3/27 13:15
 */
@Getter
@Setter
public class LostHandleBookRequest extends BaseRequest {
    @ApiModelProperty("共享记录ID")
    private Long shareRecordId;
}
