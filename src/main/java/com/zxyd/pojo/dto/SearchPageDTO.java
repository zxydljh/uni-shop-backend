package com.zxyd.pojo.dto;

import lombok.Data;

/**
 * @Author LJH
 * @Date 2024/9/1 21:23
 * @Version 1.0
 * @Description:
 */
@Data
public class SearchPageDTO {
    private String keyword;
    private Long cid; // 分类id
    private Integer pageNum;
    private Integer pageSize;

    // 用于后端分页查询
    private Integer offset;
}
