package com.zxyd.controller;

import com.zxyd.pojo.entities.ProductItem;
import com.zxyd.result.Result;
import com.zxyd.service.ProductItemService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @Author LJH
 * @Date 2024/9/2 12:54
 * @Version 1.0
 * @Description:
 */
@RestController
@Slf4j
@RequestMapping("/product")
public class ProductController {
    @Resource
    private ProductItemService productItemService;

    @GetMapping("/getProductById/{id}")
    public Result<ProductItem> getProductById(@PathVariable("id") Long id){
        log.info("getProductById:{}", id);
        ProductItem productItem = productItemService.getProductById(id);
        return Result.success(productItem);
    }
}
