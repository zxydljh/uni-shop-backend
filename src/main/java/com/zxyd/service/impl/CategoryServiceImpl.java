package com.zxyd.service.impl;

import com.zxyd.mapper.CategoryMapper;
import com.zxyd.mapper.CommodityMapper;
import com.zxyd.mapper.ProductItemMapper;
import com.zxyd.pojo.entities.Category;
import com.zxyd.pojo.entities.Commodity;
import com.zxyd.pojo.entities.ProductItem;
import com.zxyd.pojo.vo.CategoryMultilevelDirectory;
import com.zxyd.service.CategoryService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author LJH
 * @Date 2024/9/1 9:26
 * @Version 1.0
 * @Description:
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Resource
    private CategoryMapper categoryMapper; // 一级目录

    @Resource
    private CommodityMapper commodityMapper; // 二级目录

    @Resource
    private ProductItemMapper productItemMapper; // 三级目录

    /**
     * 获取多级目录
     * @return
     */
    @Override
    public List<CategoryMultilevelDirectory> getCateMultiDirList() {
        List<Category> categoryList = categoryMapper.selectAll();

        if (!categoryList.isEmpty()) {
            List<CategoryMultilevelDirectory> multilevelDirectoryList = new ArrayList<>();
            // 调用方法 获取封装数据
            categoryList.forEach(category -> {
                // 去除 分类
                if (category.getName().equals("分类")) {
                    return;
                }

                CategoryMultilevelDirectory categoryMultilevelDirectory = new CategoryMultilevelDirectory();
                categoryMultilevelDirectory.setId(category.getId());
                categoryMultilevelDirectory.setName(category.getName());
                categoryMultilevelDirectory.setIconUrl(category.getIconUrl());
                categoryMultilevelDirectory.setLevel(1);

                // 获取该目录的孩子列表
                categoryMultilevelDirectory.setChildren(this.getChildrenList(category.getId(),"category"));

                multilevelDirectoryList.add(categoryMultilevelDirectory);
            });

            return multilevelDirectoryList;
        } else {
            throw new RuntimeException("分类数据异常！");
        }
    }

    // 获取多级目录的孩子列表方法
    private List<CategoryMultilevelDirectory> getChildrenList(Long id, String type) {
        if (type.equals("category")) {
            List<Commodity> commodityList = commodityMapper.selectByCategoryId(id);
            List<CategoryMultilevelDirectory> childrenList = commodityList.stream().map(commodity -> {

                CategoryMultilevelDirectory categoryMultilevelDirectory = new CategoryMultilevelDirectory();
                categoryMultilevelDirectory.setId(commodity.getId());
                categoryMultilevelDirectory.setName(commodity.getName());
                categoryMultilevelDirectory.setIconUrl(commodity.getImageUrl());
                // TODO 数据表中没有 linkUrl
                categoryMultilevelDirectory.setLinkUrl("#");
                categoryMultilevelDirectory.setLevel(2);

                // 创建该目录的孩子列表
                // 递归调用
                List<CategoryMultilevelDirectory> children2 = this.getChildrenList(commodity.getId(), "commodity");;

                if (children2 != null && !children2.isEmpty()) {
                    categoryMultilevelDirectory.setChildren(children2);
                } else {
                    categoryMultilevelDirectory.setChildren(new ArrayList<>()); // 设置为空列表，不是null
                }

                return categoryMultilevelDirectory;
            }).collect(Collectors.toList());

            return childrenList;

        } else if (type.equals("commodity")) {
            List<ProductItem> productItemList = productItemMapper.selectByCommodityId(id);
            return productItemList.stream().map(productItem -> {
                CategoryMultilevelDirectory categoryMultilevelDirectory = new CategoryMultilevelDirectory();
                categoryMultilevelDirectory.setId(productItem.getId());
                categoryMultilevelDirectory.setName(productItem.getName());
                categoryMultilevelDirectory.setIconUrl(productItem.getImageUrl());
                // TODO 数据表中没有 linkUrl
                categoryMultilevelDirectory.setLinkUrl("#");
                categoryMultilevelDirectory.setLevel(3);

                categoryMultilevelDirectory.setChildren(null); // 明确孩子列表为空

                return categoryMultilevelDirectory;
            }).collect(Collectors.toList());

        } else {
            throw new RuntimeException("type 参数错误");
        }
    }

}
