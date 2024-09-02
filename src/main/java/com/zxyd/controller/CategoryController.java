package com.zxyd.controller;

import com.zxyd.pojo.vo.CategoryItemVO;
import com.zxyd.pojo.vo.CategoryMultilevelDirectory;
import com.zxyd.result.Result;
import com.zxyd.service.CategoryService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author LJH
 * @Date 2024/9/1 9:24
 * @Version 1.0
 * @Description:
 */
@RestController
@Slf4j
@RequestMapping("/category")
public class CategoryController {
    @Resource
    private CategoryService categoryService;

    /**
     * 获取分类列表
     * @return
     */
    @RequestMapping("/getCateMultiDirList")
    public Result<List<CategoryMultilevelDirectory>> list(){
        log.info("获取分类列表");
        List<CategoryMultilevelDirectory> list = categoryService.getCateMultiDirList();
        return Result.success(list);
    }
}
