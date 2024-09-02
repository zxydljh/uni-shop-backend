package com.zxyd.service;

import com.zxyd.pojo.vo.CarouselItemVO;
import com.zxyd.pojo.vo.CategoryItemVO;
import com.zxyd.pojo.vo.FloorVO;

import java.util.List;

/**
 * @Author LJH
 * @Date 2024/8/31 11:41
 * @Version 1.0
 * @Description:
 */
public interface HomeService {
    /**
     * 获取轮播图
     */
    List<CarouselItemVO> getSwiperList();

    /**
     * 获取分类导航列表
     * @return
     */
    List<CategoryItemVO> getCategoryNavList();

    /**
     * 获取楼层列表
     * @return
     */
    List<FloorVO> getFloorList();

}
