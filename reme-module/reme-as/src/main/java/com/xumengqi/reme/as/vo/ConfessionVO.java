package com.xumengqi.reme.as.vo;

import com.xumengqi.reme.base.BaseVO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author xumengqi
 * @date 2021/3/12 11:20
 */
@Getter
@Setter
public class ConfessionVO extends BaseVO {
    /**
     * 表白ID
     */
    private Long confessionId;

    /**
     * 表白标题
     */
    private String confessionTitle;

    /**
     * 表白详情
     */
    private String confessionDetail;

    /**
     * 表白是否匿名
     */
    private Integer isAnonymous;

    /**
     * 表白标签ID
     */
    private Long confessionTagId;

    /**
     * 表白位置
     */
    private String confessionLocation;

    /**
     * 表白是否解决
     */
    private Integer isSolved;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModified;

    /**
     * 表白标签名称
     */
    private String confessionTagName;

    /**
     * 用户姓名
     */
    private String userName;


    /**
     * 用户头像附件ID
     */
    private Long avatarAttachId;

    /**
     * 用户头像路径
     */
    private String avatarFullPath;
}
