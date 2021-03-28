package com.xumengqi.reme.api.book.dto;

import com.xumengqi.reme.base.BaseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author xumengqi
 * @date 2021/3/28 14:01
 */
@Getter
@Setter
public class ShareLogDTO extends BaseDTO {
    /**
     * 共享日志ID
     */
    private Long id;

    /**
     * 共享记录ID
     */
    private Long shareRecordId;

    /**
     * 共享记录状态【1：已下单，2：借阅中，3：已归还，4：逾期归还，5：下单后取消，6：书籍丢失或严重受损，7：书籍超时严重不归还】
     */
    private Integer shareRecordStatus;

    /**
     * 操作人类型【1：共享者，2：借阅者】
     */
    private Integer operatorType;

    /**
     * 创建时间
     */
    private Date gmtCreate;
}
