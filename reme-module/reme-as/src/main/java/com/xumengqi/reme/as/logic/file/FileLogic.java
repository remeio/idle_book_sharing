package com.xumengqi.reme.as.logic.file;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Set;

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
     * @return ids
     */
    List<Long> uploadFiles(MultipartFile[] files, String userId);


    /**
     * 获取访问链接
     * @param attachIdSet /
     * @return /
     */
    Map<Long, String> getFileFullPaths(Set<Long> attachIdSet);
}
