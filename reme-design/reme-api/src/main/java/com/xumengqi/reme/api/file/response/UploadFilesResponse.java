package com.xumengqi.reme.api.file.response;

import com.xumengqi.reme.base.BaseResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author xumengqi
 * @date 2021/2/27 12:01
 */
@Getter
@Setter
public class UploadFilesResponse extends BaseResponse {
    @ApiModelProperty("文件访问路径列表")
    private List<String> filePathList;
}
