package com.zxyd.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author LJH
 * @Date 2024/9/1 19:23
 * @Version 1.0
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchVO {
    private Long id;
    private String description;
}
