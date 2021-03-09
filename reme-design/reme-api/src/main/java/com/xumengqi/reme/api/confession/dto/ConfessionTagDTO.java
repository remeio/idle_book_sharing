package com.xumengqi.reme.api.confession.dto;

import com.xumengqi.reme.base.BaseDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @author xumengqi
 * @date 2021/3/9 17:50
 */
@Getter
@Setter
public class ConfessionTagDTO extends BaseDTO {
    private Long confessionTagId;

    private String confessionTagName;
}
