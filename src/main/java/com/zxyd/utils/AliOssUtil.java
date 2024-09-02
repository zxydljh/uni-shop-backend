package com.zxyd.utils;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.zxyd.properties.AliOssProperties;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.time.LocalDate;

/**
 * @Author LJH
 * @Date 2024/8/31 12:45
 * @Version 1.0
 * @Description:
 */
@Slf4j
@Component
public class AliOssUtil {
    @Resource
    private AliOssProperties aliOssProperties;

    /**
     * 文件上传
     *
     * @param bytes
     * @param objectName
     * @return
     */
    public String upload(byte[] bytes, String objectName) {
        // 根据当天日期创建文件夹
        LocalDate now = LocalDate.now();
        objectName = now.getYear() + "/" + now.getMonthValue() + "/" + now.getDayOfMonth() + "/" + objectName;

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(aliOssProperties.getEndpoint(), aliOssProperties.getAccessKeyId(), aliOssProperties.getAccessKeySecret());

        try {
            // 创建PutObject请求。
            ossClient.putObject(aliOssProperties.getBucketName(), objectName, new ByteArrayInputStream(bytes));
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
        } catch (ClientException ce) {
            System.out.println("Error Message:" + ce.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }

        //文件访问路径规则 https://BucketName.Endpoint/ObjectName
        StringBuilder stringBuilder = new StringBuilder("https://");
        stringBuilder
                .append(aliOssProperties.getBucketName())
                .append(".")
                .append(aliOssProperties.getEndpoint())
                .append("/")
                .append(objectName);

        log.info("文件上传到:{}", stringBuilder.toString());

        return stringBuilder.toString();
    }
}
