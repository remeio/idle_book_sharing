package com.xumengqi.reme.api.book.request;

import com.xumengqi.reme.base.BaseRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author xumengqi
 * @date 2021/4/1 15:23
 */
@Getter
@Setter
public class GetMessageListRequest extends BaseRequest {
    @ApiModelProperty("共享记录ID")
    private Long shareRecordId;

}
