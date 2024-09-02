package com.zxyd.handler;

import com.zxyd.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author LJH
 * @Date 2024/5/16 9:29
 * @Version 1.0
 * @Description: 捕获业务异常
 */

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        log.info("线程:{},异常:{}", t.getName(), e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public Result<String> runtimeExceptionHandler(RuntimeException e) {
        log.error("运行时异常:{}", e.getMessage());
        return Result.error(e.getMessage());
    }
}
