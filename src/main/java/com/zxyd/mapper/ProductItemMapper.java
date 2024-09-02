package com.zxyd.mapper;

import com.zxyd.pojo.dto.SearchPageDTO;
import com.zxyd.pojo.entities.ProductItem;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ProductItemMapper extends Mapper<ProductItem> {
    @Select("select * from product_item where commodity_id = #{id} and is_active = 1")
    List<ProductItem> selectByCommodityId(Long id);

    List<ProductItem> pageQuery(SearchPageDTO searchPageDTO);
}