package com.zxyd.pojo.vo;

import com.zxyd.pojo.entities.ProductItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author LJH
 * @Date 2024/9/1 21:27
 * @Version 1.0
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchPageVO {
    private Integer total;
    private List<ProductItem> goods;
}
