package com.zxyd.service.impl;

import com.zxyd.mapper.CarouselMapper;
import com.zxyd.mapper.CategoryMapper;
import com.zxyd.mapper.CommodityMapper;
import com.zxyd.pojo.entities.Carousel;
import com.zxyd.pojo.entities.Category;
import com.zxyd.pojo.entities.Commodity;
import com.zxyd.pojo.vo.CarouselItemVO;
import com.zxyd.pojo.vo.CategoryItemVO;
import com.zxyd.pojo.vo.CommodityVO;
import com.zxyd.pojo.vo.FloorVO;
import com.zxyd.service.HomeService;
import jakarta.annotation.Resource;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author LJH
 * @Date 2024/8/31 11:41
 * @Version 1.0
 * @Description:
 */
@Service
public class HomeServiceImpl implements HomeService {
    @Resource
    private CarouselMapper carouselMapper;

    @Resource
    private CategoryMapper categoryMapper;

    @Resource
    private CommodityMapper commodityMapper;

    @Override
    public List<CarouselItemVO> getSwiperList() {
         List<Carousel> carousels = carouselMapper.selectAll();
        if (carousels != null && !carousels.isEmpty()) {
            return carousels.stream().map(carousel -> {
                CarouselItemVO carouselItemVO = new CarouselItemVO();
                carouselItemVO.setTitle(carousel.getTitle());
                carouselItemVO.setGoodsId(carousel.getGoodsId());
                carouselItemVO.setImageUrl(carousel.getImageUrl());
                carouselItemVO.setLinkUrl(carousel.getLinkUrl());
                return carouselItemVO;
            }).toList();
        } else {
            throw new RuntimeException("轮播图数据异常！");
        }
    }

    @Override
    public List<CategoryItemVO> getCategoryNavList() {
        // 创建Example对象，指定查询实体类为Category
        Example example = new Example(Category.class);

        // 创建查询条件，筛选出isActive为true的记录
        example.createCriteria().andEqualTo("isActive", true);

        // 使用RowBounds限制查询结果为4个
        RowBounds rowBounds = new RowBounds(0, 4); // 从第0条开始，取4条记录

        // 根据构建的查询条件执行查询
        List<Category> categories = categoryMapper.selectByExampleAndRowBounds(example, rowBounds);

        // 将Category列表转换为CategoryItemVO列表
        List<CategoryItemVO> categoryItemVOs = categories.stream()
                .map(category -> new CategoryItemVO(
                        category.getId(),
                        category.getName(),
                        category.getIconUrl(),
                        category.getLinkUrl()
                ))
                .collect(Collectors.toList());

        return categoryItemVOs;
    }

    /**
     * 获取楼层列表
     * @return
     */
    @Override
    public List<FloorVO> getFloorList() {
        // 获取三个分类
        // 创建Example对象，指定查询实体类为Category
        Example example = new Example(Category.class);

        // 创建查询条件，筛选出isActive为true的记录
        example.createCriteria().andEqualTo("isActive", true);

        // 使用RowBounds限制查询结果为4个
        RowBounds rowBounds = new RowBounds(0, 4); // 从第0条开始，取4条记录

        // 根据构建的查询条件执行查询
        List<Category> categories = categoryMapper.selectByExampleAndRowBounds(example, rowBounds);

        if (categories != null && !categories.isEmpty()) {
            // 过滤掉分类名为“分类”的分类
            categories.removeIf(category -> "分类".equals(category.getName()));

            List<FloorVO> floorVOList = new ArrayList<>();
            for (Category category : categories) {
                FloorVO floorVO = new FloorVO();
                floorVO.setCategoryItemVO(new CategoryItemVO(category.getId(), category.getName(), category.getIconUrl(), category.getLinkUrl()));
                // 获取该分类下的商品
                Example example1 = new Example(Commodity.class);
                example1.createCriteria().andEqualTo("categoryId", category.getId());
                // 使用RowBounds限制查询结果为5个
                rowBounds = new RowBounds(0, 5); // 从第0条开始，取5条记录
                List<Commodity> commodities = commodityMapper.selectByExampleAndRowBounds(example1, rowBounds);

                // 将商品列表转换为CommodityVO列表
                if (commodities != null && !commodities.isEmpty()) {
                    List<CommodityVO> commodityVOList = commodities.stream()
                            .map(commodity -> new CommodityVO(commodity.getId(), commodity.getName(), commodity.getImageUrl()))
                            .collect(Collectors.toList());

                    floorVO.setCommodityVOList(commodityVOList);
                    floorVOList.add(floorVO);
                }
            }
            return floorVOList;
        } else {
            throw new RuntimeException("分类数据异常！");
        }
    }
}
