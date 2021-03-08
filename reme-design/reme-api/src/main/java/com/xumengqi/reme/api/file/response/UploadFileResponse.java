package com.xumengqi.reme.api.file.response;

import com.xumengqi.reme.base.BaseResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 上传文件响应
 *
 * @author xumengqi
 */
@Getter
@Setter
public class UploadFileResponse extends BaseResponse {
    @ApiModelProperty("文件 ID 列表")
    private List<Long> fileIds;
}
