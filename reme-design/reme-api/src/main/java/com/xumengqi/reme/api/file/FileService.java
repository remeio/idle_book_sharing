package com.xumengqi.reme.api.file;

import com.xumengqi.reme.api.file.response.UploadFileResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
     *
     * @param files /
     * @param token /
     * @return /
     */
    @ApiOperation("上传文件")
    @PostMapping("/upload")
    UploadFileResponse upload(@RequestParam(name = "files") MultipartFile[] files, @RequestParam(name = "token") String token);

}
