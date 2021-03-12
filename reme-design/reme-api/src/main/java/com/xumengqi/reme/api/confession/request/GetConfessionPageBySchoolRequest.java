package com.xumengqi.reme.api.confession.request;

import com.xumengqi.reme.base.PageRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * @author xumengqi
 * @date 2021/3/10 17:21
 */
@Getter
@Setter
public class GetConfessionPageBySchoolRequest extends PageRequest {
    @ApiModelProperty("学校ID")
    private Long schoolId;

    @ApiModelProperty("标签集合")
    private Set<Long> confessionTagIdSet;

    @ApiModelProperty("解决与否")
    private Integer isSolved;
}
