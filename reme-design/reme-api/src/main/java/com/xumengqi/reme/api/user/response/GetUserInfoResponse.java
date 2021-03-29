package com.xumengqi.reme.api.user.response;

import com.xumengqi.reme.api.user.dto.UserDTO;
import com.xumengqi.reme.base.BaseResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author xumengqi
 * @date 2021/3/29 13:27
 */
@Getter
@Setter
public class GetUserInfoResponse extends BaseResponse {
    @ApiModelProperty("用户信息")
    private UserDTO userDTO;
}
