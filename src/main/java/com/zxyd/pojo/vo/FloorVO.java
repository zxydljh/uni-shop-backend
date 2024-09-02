package com.zxyd.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author LJH
 * @Date 2024/8/31 20:54
 * @Version 1.0
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FloorVO {
    private CategoryItemVO categoryItemVO;
    private List<CommodityVO> commodityVOList;
}
