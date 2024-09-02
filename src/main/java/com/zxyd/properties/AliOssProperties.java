package com.zxyd.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author LJH
 * @Date 2024/8/31 12:47
 * @Version 1.0
 * @Description:
 */
@Configuration
@ConfigurationProperties(prefix = "uni-shop.alioss")
@Data
public class AliOssProperties {
    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
}
