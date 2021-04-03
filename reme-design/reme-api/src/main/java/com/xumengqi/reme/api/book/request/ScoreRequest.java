package com.xumengqi.reme.api.book.request;

import com.xumengqi.reme.base.BaseRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author xumengqi
 * @date 2021/4/3 14:15
 */
@Getter
@Setter
public class ScoreRequest extends BaseRequest {
    @ApiModelProperty("共享记录ID")
    @NotNull
    private Long shareRecordId;

    @ApiModelProperty("评分")
    @Min(value = 1, message = "最低评分为 1 分")
    @Max(value = 5, message = "满分为 5 分")
    private Double score;
}
