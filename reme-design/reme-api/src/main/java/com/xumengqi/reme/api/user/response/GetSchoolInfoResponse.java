package com.xumengqi.reme.api.user.response;

import com.xumengqi.reme.base.BaseResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author xumengqi
 * @date 2021/3/25 13:10
 */
@Getter
@Setter
public class GetSchoolInfoResponse extends BaseResponse {
    @ApiModelProperty("学校ID")
    private Long schoolId;

    @ApiModelProperty("学校名称")
    private String schoolName;
}
