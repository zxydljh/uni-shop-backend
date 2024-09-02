package com.zxyd.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author LJH
 * @Date 2024/8/31 19:44
 * @Version 1.0
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryItemVO {
    private Long id;
    private String name;
    private String iconUrl;
    private String linkUrl;
}
