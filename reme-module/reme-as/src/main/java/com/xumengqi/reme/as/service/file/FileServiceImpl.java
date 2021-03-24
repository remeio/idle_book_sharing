package com.xumengqi.reme.as.service.file;

import com.xumengqi.reme.api.file.FileService;
import com.xumengqi.reme.api.file.response.UploadFileResponse;
import com.xumengqi.reme.api.file.response.UploadFilesResponse;
import com.xumengqi.reme.as.logic.file.FileLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 文件上传服务实现类
 *
 * @author xumengqo
 */
@Component
public class FileServiceImpl implements FileService {

    @Autowired
    private FileLogic fileLogic;

    @Override
    public UploadFilesResponse uploadFiles(MultipartFile[] files) {
        List<String> filePathList = fileLogic.uploadFiles(files);
        UploadFilesResponse response = new UploadFilesResponse();
        response.setFilePathList(filePathList);
        return response;
    }

    @Override
    public UploadFileResponse uploadFile(MultipartFile file) {
        String filePath = fileLogic.uploadFile(file);
        UploadFileResponse response = new UploadFileResponse();
        response.setFilePath(filePath);
        return response;
    }
}
