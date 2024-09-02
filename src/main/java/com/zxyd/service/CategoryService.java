package com.zxyd.service;

import com.zxyd.pojo.vo.CategoryMultilevelDirectory;

import java.util.List;

/**
 * @Author LJH
 * @Date 2024/9/1 9:26
 * @Version 1.0
 * @Description:
 */
public interface CategoryService {
    /**
     * 获取多级目录
     * @return
     */
    List<CategoryMultilevelDirectory> getCateMultiDirList();
}
