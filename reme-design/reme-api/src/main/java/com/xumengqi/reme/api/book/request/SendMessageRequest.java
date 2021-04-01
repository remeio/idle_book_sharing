package com.xumengqi.reme.api.book.request;

import com.xumengqi.reme.base.BaseRequest;
import com.xumengqi.reme.base.validation.ChineseLength;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * @author xumengqi
 * @date 2021/4/1 15:13
 */
@Getter
@Setter
public class SendMessageRequest extends BaseRequest {
    @ApiModelProperty("共享记录ID")
    @NotNull
    private Long shareRecordId;

    @ApiModelProperty("消息内容")
    @ChineseLength(min = 1, max = 100)
    private String messageContent;
}
