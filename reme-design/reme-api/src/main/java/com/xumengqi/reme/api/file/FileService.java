package com.xumengqi.reme.api.file;

import com.xumengqi.reme.api.file.response.UploadFileResponse;
import com.xumengqi.reme.api.file.response.UploadFilesResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件服务
 *
 * @author xumengqi
 */
@Api(tags = "FileService", description = "文件服务")
@RequestMapping("/file")
@RestController
public interface FileService {

    /**
     * 上传多个文件
     *
     * @param files /
     * @return /
     */
    @ApiOperation("上传多个文件")
    @PostMapping("/uploadFiles")
    UploadFilesResponse uploadFiles(@RequestParam(name = "files[]") MultipartFile[] files);

    /**
     * 上传单个文件
     *
     * @param file /
     * @return /
     */
    @ApiOperation("上传单个文件")
    @PostMapping("/uploadFile")
    UploadFileResponse uploadFile(@RequestParam MultipartFile file);

}
