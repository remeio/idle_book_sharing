package com.xumengqi.reme.api.file;

import com.xumengqi.reme.api.file.request.UploadFileRequest;
import com.xumengqi.reme.api.file.response.UploadFileResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

/**
 * 文件服务
 * @author xumengqi
 */
@Api(tags = "FileService", description = "文件服务")
@RequestMapping("/file")
@RestController
public interface FileService {

    /**
     * 上传文件，可上传多个文件
     * @param request /
     * @return /
     */
    @ApiOperation("上传文件")
    @PostMapping("/upload")
    UploadFileResponse upload(@RequestParam(name = "files") MultipartFile files);

}
