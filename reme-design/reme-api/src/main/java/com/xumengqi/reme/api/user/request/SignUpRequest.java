package com.xumengqi.reme.api.user.request;

import com.xumengqi.reme.base.BaseRequest;
import com.xumengqi.reme.base.validation.Phone;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @author xumengqi
 * @date 2021/2/27 12:00
 */
@Getter
@Setter
public class SignUpRequest extends BaseRequest {

    @ApiModelProperty("用户手机号")
    @Phone
    private String userPhone;

    @ApiModelProperty("用户密码")
    @Length(min = 1, max = 100, message = "用户密码输入不合法")
    private String userPassword;

    @ApiModelProperty("用户名称")
    @Length(min = 2, max = 100, message = "用户名称输入不合法")
    private String userFullName;

    @ApiModelProperty("学校名称")
    @NotNull(message = "学校名称不能为空")
    private String schoolName;
}
