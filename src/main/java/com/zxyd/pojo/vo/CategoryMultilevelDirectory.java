package com.zxyd.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author LJH
 * @Date 2024/9/1 9:41
 * @Version 1.0
 * @Description: 分类多级目录
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryMultilevelDirectory {
    private Long id;
    private String name;
    private String iconUrl;
    private String linkUrl;
    private Integer level; // 层级 1 category 2 commodity 3 product_item
    private List<CategoryMultilevelDirectory> children; // 子级分类
}
