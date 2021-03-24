package com.xumengqi.reme.api.file.response;

import com.xumengqi.reme.base.BaseResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author xumengqi
 * @date 2021/2/27 12:01
 */
@Getter
@Setter
public class UploadFileResponse extends BaseResponse {
    @ApiModelProperty("文件访问路径")
    private String filePath;
}
