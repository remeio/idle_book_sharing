package com.xumengqi.reme.as.service.file;

import com.xumengqi.reme.api.file.FileService;
import com.xumengqi.reme.api.file.response.UploadFileResponse;
import com.xumengqi.reme.as.logic.file.FileLogic;
import com.xumengqi.reme.base.util.RedisUtils;
import com.xumengqi.reme.common.enums.ErrorCodeEnum;
import com.xumengqi.reme.common.enums.RedisKeyPrefixEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传服务实现类
 *
 * @author xumengqo
 */
@Component
public class FileServiceImpl implements FileService {
    @Autowired
    private RedisUtils<String> redisUtils;

    @Autowired
    private FileLogic fileLogic;

    @Override
    public UploadFileResponse upload(MultipartFile[] files, String token) {
        // 将 token 与缓存中的进行对比
        String key = RedisKeyPrefixEnum.ACCESS_TOKEN.getPrefix() + token;
        String userId = redisUtils.get(key);
        if (userId == null) {
            UploadFileResponse response = new UploadFileResponse();
            response.error(ErrorCodeEnum.INVALID_TOKEN);
            return response;
        }
        fileLogic.uploadFiles(files, userId);
        return new UploadFileResponse();
    }
}
