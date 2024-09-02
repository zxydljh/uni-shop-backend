package com.zxyd;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author LJH
 * @Date 2024/8/31 10:46
 * @Version 1.0
 * @Description:
 */
@SpringBootApplication
@MapperScan("com.zxyd.mapper")
public class Main8080 {
    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(Main8080.class, args);
    }
}