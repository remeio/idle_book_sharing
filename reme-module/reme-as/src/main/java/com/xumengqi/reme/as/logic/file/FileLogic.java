package com.xumengqi.reme.as.logic.file;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author xumengqi
 * @date 2021/3/8 12:58
 */
public interface FileLogic {
    /**
     * 上传多个文件
     *
     * @param files 文件
     * @return paths 访问路径
     */
    List<String> uploadFiles(MultipartFile[] files);

    /**
     * 上传单个文件
     *
     * @param file 文件
     * @return path 访问路径
     */
    String uploadFile(MultipartFile file);
}
