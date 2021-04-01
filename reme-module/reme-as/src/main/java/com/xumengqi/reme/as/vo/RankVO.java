package com.xumengqi.reme.as.vo;

import com.xumengqi.reme.base.BaseDTO;
import com.xumengqi.reme.base.BaseVO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

/**
 * @author xumengqi
 * @date 2021/4/1 12:28
 */
@Getter
@Setter
public class RankVO extends BaseVO {
    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 名称
     */
    private String userFullName;

    /**
     * 次数
     */
    private Integer number;

}
