package com.zxyd.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author LJH
 * @Date 2024/8/31 15:36
 * @Version 1.0
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarouselItemVO {
    private String title;
    private Long goodsId;
    private String imageUrl;
    private String linkUrl;
}
