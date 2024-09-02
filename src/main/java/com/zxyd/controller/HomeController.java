package com.zxyd.controller;

import com.zxyd.pojo.entities.Carousel;
import com.zxyd.pojo.vo.CarouselItemVO;
import com.zxyd.pojo.vo.CategoryItemVO;
import com.zxyd.pojo.vo.FloorVO;
import com.zxyd.result.Result;
import com.zxyd.service.HomeService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author LJH
 * @Date 2024/8/31 10:54
 * @Version 1.0
 * @Description:
 */
@RestController
@RequestMapping("/home")
@Slf4j
public class HomeController {
    @Resource
    private HomeService homeService;

    /**
     * 获取轮播图列表
     * @return
     */
    @GetMapping("/getSwiperList")
    public Result<List<CarouselItemVO>> getSwiperList() {
        log.info("获取轮播图列表");
        List<CarouselItemVO> list = homeService.getSwiperList();
        return Result.success(list);
    }

    /**
     * 获取分类导航列表
     * @return
     */
    @GetMapping("/getNavList")
    public Result<List<CategoryItemVO>> getCategoryNavList() {
        log.info("获取分类列表");
        List<CategoryItemVO> list = homeService.getCategoryNavList();
        return Result.success(list);
    }

    /**
     * 获取楼层列表
     * @return
     */
    @GetMapping("/getFloorList")
    public Result<List<FloorVO>> getFloorList() {
        log.info("获取分类列表");
        List<FloorVO> list = homeService.getFloorList();
        return Result.success(list);
    }
}
