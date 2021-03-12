package com.xumengqi.reme.as.logic.file.impl;

import com.xumengqi.reme.as.logic.file.FileLogic;
import com.xumengqi.reme.base.BizException;
import com.xumengqi.reme.base.util.AssertUtils;
import com.xumengqi.reme.base.util.MinioUtils;
import com.xumengqi.reme.common.enums.ErrorCodeEnum;
import com.xumengqi.reme.dao.entity.Attach;
import com.xumengqi.reme.dao.entity.AttachExample;
import com.xumengqi.reme.dao.mapper.AttachMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

/**
 * @author xumengqi
 * @date 2021/3/8 12:59
 */
@Component
public class FileLogicImpl implements FileLogic {
    private static final Logger log = Logger.getLogger(FileLogicImpl.class);

    @Autowired
    private MinioUtils minioUtils;

    @Autowired
    private AttachMapper attachMapper;

    final static String BUCKET_NAME = "attach";

    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<Long> uploadFiles(MultipartFile[] files, String userId) {
        assert files != null && StringUtils.isNotBlank(userId);
        List<Long> attachIds = new ArrayList<>();
        for (MultipartFile file : files) {
            // 生成文件名
            String originalFileName = file.getOriginalFilename();
            assert originalFileName != null;
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
            long fileSize = file.getSize();
            // 数据库插入记录
            Attach attach = new Attach();
            attach.setAttachName(originalFileName);
            attach.setAttachFullPath("/" + BUCKET_NAME + "/" + fileName);
            attach.setAttachSize(fileSize);
            attach.setUserId(Long.parseLong(userId));
            attach.setGmtCreate(new Date());
            attachMapper.insertSelective(attach);
            attachIds.add(attach.getAttachId());
        }
        return attachIds;
    }

    @Override
    public Map<Long, String> getFileFullPaths(Set<Long> attachIdSet) {
        assert attachIdSet != null && attachIdSet.size() > 0;
        AttachExample attachExample = new AttachExample();
        attachExample.createCriteria()
                .andAttachIdIn(new ArrayList<>(attachIdSet));
        List<Attach> attachList = attachMapper.selectByExample(attachExample);
        AssertUtils.asserter()
                .assertTrue(attachIdSet.size() == attachList.size())
                .elseThrow(ErrorCodeEnum.ATTACH_NOT_EXIST);
        Map<Long, String> longStringMap = new HashMap<>(attachList.size());
        final String url = minioUtils.getMinioConfig().getUrl();
        attachList.forEach(e -> {
            longStringMap.put(e.getAttachId(), url + e.getAttachFullPath());
        });
        return longStringMap;
    }
}
