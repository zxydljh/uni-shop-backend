package com.zxyd.service;

import com.zxyd.pojo.dto.SearchPageDTO;
import com.zxyd.pojo.entities.ProductItem;
import com.zxyd.pojo.vo.SearchPageVO;
import com.zxyd.pojo.vo.SearchVO;

import java.util.List;

/**
 * @Author LJH
 * @Date 2024/9/1 19:20
 * @Version 1.0
 * @Description:
 */
public interface ProductItemService {
    List<SearchVO> queryByKeyword(String keyword);

    SearchPageVO searchPageList(SearchPageDTO searchPageDTO);

    ProductItem getProductById(Long id);
}
