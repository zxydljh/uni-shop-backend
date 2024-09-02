package com.zxyd.mapper;

import com.zxyd.pojo.entities.Commodity;
import com.zxyd.pojo.vo.CategoryMultilevelDirectory;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CommodityMapper extends Mapper<Commodity> {
    /**
     * 根据分类id查询商品
     * @param id
     * @return
     */
    @Select("SELECT * FROM commodity WHERE category_id = #{id} AND is_active = 1")
    List<Commodity> selectByCategoryId(Long id);
}