package com.xumengqi.reme.api.user.request;

import com.xumengqi.reme.base.BaseRequest;
import com.xumengqi.reme.base.validation.ChineseLength;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * @author xumengqi
 * @date 2021/4/1 14:35
 */
@Getter
@Setter
public class FeedbackRequest extends BaseRequest {
    @ApiModelProperty("反馈内容")
    @ChineseLength(min = 1, max = 500)
    private String feedbackContent;

    @ApiModelProperty("反馈关联订单")
    private String feedbackOrder;
}
