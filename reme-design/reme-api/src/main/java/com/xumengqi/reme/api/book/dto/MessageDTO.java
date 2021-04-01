package com.xumengqi.reme.api.book.dto;

import com.xumengqi.reme.base.BaseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author xumengqi
 * @date 2021/4/1 15:21
 */
@Getter
@Setter
public class MessageDTO extends BaseDTO {
    /**
     * 主键
     */
    private Long id;

    /**
     * 消息内容
     */
    private String messageContent;

    /**
     * 共享记录ID
     */
    private Long shareRecordId;

    /**
     * 操作人类型【1：共享者，2：借阅者】
     */
    private Integer operatorType;

    /**
     * 创建时间
     */
    private Date gmtCreate;
}
