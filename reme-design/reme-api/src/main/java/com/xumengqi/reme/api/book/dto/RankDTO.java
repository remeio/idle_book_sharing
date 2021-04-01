package com.xumengqi.reme.api.book.dto;

import com.xumengqi.reme.base.BaseDTO;
import lombok.Getter;
import org.springframework.stereotype.Service;

/**
 * @author xumengqi
 * @date 2021/4/1 12:28
 */
@Getter
@Service
public class RankDTO extends BaseDTO {
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
