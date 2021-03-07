package com.xumengqi.reme.as.service.file;

import com.xumengqi.reme.api.file.FileService;
import com.xumengqi.reme.api.file.response.UploadFileResponse;
import com.xumengqi.reme.base.util.MinioUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传服务实现类
 * @author xumengqo
 */
@Component
public class FileServiceImpl implements FileService {
    @Autowired
    private MinioUtils minioUtils;

    @Override
    public UploadFileResponse upload(MultipartFile[] files) {
        try {
            minioUtils.upload("test-bucket", files[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new UploadFileResponse();
    }
}
