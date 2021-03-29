package com.xumengqi.reme.api.user.dto;

import com.xumengqi.reme.base.BaseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author xumengqi
 * @date 2021/3/29 13:27
 */
@Getter
@Setter
public class UserDTO extends BaseDTO {
    /**
     * 用户ID
     */
    private Long id;

    /**
     * 用户手机号
     */
    private String userPhone;

    /**
     * 用户密码
     */
    private String userPassword;

    /**
     * 用户姓名
     */
    private String userFullName;

    /**
     * 学校ID
     */
    private Long schoolId;

    /**
     * 可用押金
     */
    private Long canUseDeposit;

    /**
     * 占用押金
     */
    private Long occupyDeposit;

    /**
     * 支付损失押金
     */
    private Long lossDeposit;

    /**
     * 所得补偿押金
     */
    private Long makeUpDeposit;

    /**
     * 创建时间
     */
    private Date gmtCreate;


    // CUSTOM

    /**
     * 学校名称
     */
    private String schoolName;
}
