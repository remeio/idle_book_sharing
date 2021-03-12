package com.xumengqi.reme.api.confession.dto;

import com.xumengqi.reme.base.BaseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author xumengqi
 * @date 2021/3/10 17:34
 */
@Getter
@Setter
public class ConfessionDTO extends BaseDTO {
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
     * 浏览量
     */
    private Long browseCount;

    /**
     * 点赞量
     */
    private Long favorCount;

    /**
     * 评论回复量
     */
    private Long commentAndReplyCount;

    /**
     * 是否已点赞
     */
    private Boolean isHadFavor;

    /**
     * 是否已浏览
     */
    private Boolean isHadBrowse;

    /**
     * 用户姓名
     */
    private String userName;
}
