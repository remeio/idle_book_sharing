package com.xumengqi.reme.api.confession.response;

import com.xumengqi.reme.api.confession.dto.ConfessionDTO;
import com.xumengqi.reme.base.PageResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author xumengqi
 * @date 2021/3/10 17:21
 */
@Getter
@Setter
public class GetConfessionPageBySchoolResponse extends PageResponse {
    @ApiModelProperty("表白列表")
    List<ConfessionDTO> confessionDTOList;
}
