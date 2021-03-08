package com.xumengqi.reme.as.logic.file;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author xumengqi
 * @date 2021/3/8 12:58
 */
public interface FileLogic {
    /**
     * 上传多个文件
     *
     * @param files  文件
     * @param userId 用户 ID
     */
    void uploadFiles(MultipartFile[] files, String userId);
}
