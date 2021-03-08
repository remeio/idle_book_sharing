package com.xumengqi.reme.api.confession.request;

import com.xumengqi.reme.base.BaseRequest;
import com.xumengqi.reme.base.validation.ChineseLength;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * 发布表白
 *
 * @author xumengqi
 * @date 2021/3/8 18:01
 */
@Getter
@Setter
public class PostConfessionRequest extends BaseRequest {
    @ApiModelProperty("表白标题")
    @ChineseLength(max = 2000)
    private String confessionTitle;

    @ApiModelProperty("表白详情")
    @ChineseLength(max = 2000)
    private String confessionDetail;

    @ApiModelProperty("表白是否匿名")
    @Min(1)
    private Byte isAnonymous;

    @ApiModelProperty("表白标签ID")
    @Min(1)
    private Long confessionTagId;

    @ApiModelProperty("表白位置")
    @ChineseLength(max = 200)
    private String confessionLocation;

    @ApiModelProperty("附件ID列表")
    @Size(max = 9)
    private List<Long> attachIds;
}
