package com.xumengqi.reme.api.confession.response;

import com.xumengqi.reme.api.confession.dto.ConfessionTagDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author xumengqi
 * @date 2021/3/9 17:44
 */
@Getter
@Setter
public class GetConfessionTagListResponse {
    @ApiModelProperty("表白标签列表")
    private List<ConfessionTagDTO> confessionTagList;
}
