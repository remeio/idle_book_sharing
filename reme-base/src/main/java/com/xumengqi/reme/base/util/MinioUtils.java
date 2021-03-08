package com.xumengqi.reme.base.util;

import com.xumengqi.reme.base.conf.MinioConfig;
import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * Minio 对象存储工具类
 * @author xumengqi
 */
@Component
public class MinioUtils {

    @Autowired
    private MinioConfig minioConfig;

    private MinioClient minioClient;

    /**
     * 获取 minio 客服端
     * @return 客服端单例
     */
    public MinioClient getInstance() {
        if (minioClient == null) {
            synchronized (MinioUtils.class) {
                if (minioClient == null) {
                    minioClient = MinioClient.builder()
                            .endpoint(minioConfig.getUrl())
                            .credentials(minioConfig.getAccessKey(), minioConfig.getAccessSecret())
                            .build();
                }
            }

        }
        return minioClient;
    }

    public void upload(String bucketName, MultipartFile multipartFile, String fileName) throws Exception {
        MinioClient minioClient = getInstance();
        final InputStream inputStream = multipartFile.getInputStream();
        if (!minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build())) {
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
        }
        PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                .bucket(bucketName)
                .object(fileName == null ? multipartFile.getOriginalFilename() : fileName)
                .stream(inputStream, inputStream.available(), Math.max(inputStream.available(), 5 * 1024 * 1024))
                .build();
        getInstance().putObject(putObjectArgs);
    }
}
