package com.xumengqi.reme.as.logic.file.impl;

import com.xumengqi.reme.as.logic.file.FileLogic;
import com.xumengqi.reme.base.BizException;
import com.xumengqi.reme.base.util.MinioUtils;
import com.xumengqi.reme.common.enums.ErrorCodeEnum;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author xumengqi
 * @date 2021/3/8 12:59
 */
@Component
public class FileLogicImpl implements FileLogic {
    private static final Logger log = Logger.getLogger(FileLogicImpl.class);

    @Autowired
    private MinioUtils minioUtils;

    final static String BUCKET_NAME = "attach";

    @Override
    public List<String> uploadFiles(MultipartFile[] files) {
        List<String> filePaths = new ArrayList<>();
        for (MultipartFile file : files) {
            // 生成文件名
            String originalFileName = file.getOriginalFilename();
            String suffixDelimiter = ".";
            String fileSuffix = "";
            if (originalFileName.contains(suffixDelimiter)) {
                fileSuffix = originalFileName.substring(originalFileName.lastIndexOf(suffixDelimiter));
            }
            String fileName = UUID.randomUUID().toString() + fileSuffix;
            // 上传文件
            try {
                minioUtils.upload(BUCKET_NAME, file, fileName);
            } catch (Exception e) {
                log.info("上传文件失败 with originalFileName: " + originalFileName, e);
                BizException.error(ErrorCodeEnum.FILE_UPLOAD_FAIL);
            }
            String path = minioUtils.getMinioConfig().getUrl() + "/" + BUCKET_NAME + "/" + fileName;
            filePaths.add(path);
        }
        return filePaths;
    }

    @Override
    public String uploadFile(MultipartFile file) {
        MultipartFile[] files = new MultipartFile[]{file};
        return uploadFiles(files).get(0);
    }
}
