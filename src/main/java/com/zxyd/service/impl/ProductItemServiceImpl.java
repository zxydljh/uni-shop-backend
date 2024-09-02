package com.zxyd.service.impl;

import com.zxyd.mapper.CommodityMapper;
import com.zxyd.mapper.ProductItemMapper;
import com.zxyd.pojo.dto.SearchPageDTO;
import com.zxyd.pojo.entities.Commodity;
import com.zxyd.pojo.entities.ProductItem;
import com.zxyd.pojo.vo.SearchPageVO;
import com.zxyd.pojo.vo.SearchVO;
import com.zxyd.service.ProductItemService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Author LJH
 * @Date 2024/9/1 19:21
 * @Version 1.0
 * @Description:
 */
@Service
public class ProductItemServiceImpl implements ProductItemService {
    @Resource
    private ProductItemMapper productItemMapper;

    /**
     * 根据关键字查询
     * @param keyword
     * @return
     */
    @Override
    public List<SearchVO> queryByKeyword(String keyword) {
        Example example = new Example(ProductItem.class);
        example.createCriteria().andLike("description", "%" + keyword + "%");
//        example.or().andLike("name", "%" + keyword + "%");
        example.and().andEqualTo("isActive", 1);
        List<ProductItem> productItems = productItemMapper.selectByExample(example);

        if (productItems != null && !productItems.isEmpty()) {
            List<SearchVO> searchVOList = productItems.stream()
                    .map(
                            productItem -> new SearchVO(productItem.getId(),productItem.getDescription()))
                    .toList();

            return searchVOList;
        } else {
            throw new RuntimeException("没有找到相关商品");
        }
    }

    @Override
    public SearchPageVO searchPageList(SearchPageDTO searchPageDTO) {
        // 查询符合条件的总记录数
        Example example = new Example(ProductItem.class);
        example.and().andEqualTo("isActive", 1);

//        if (searchPageDTO.getKeyword() != null) {
//            example.or().andLike("description", "%" + searchPageDTO.getKeyword() + "%");
//        }

        if (searchPageDTO.getCid() != null) {
            example.and().andEqualTo("commodityId", searchPageDTO.getCid());
        }

        Integer total = productItemMapper.selectCountByExample(example);

        if (total == 0) {
            throw new RuntimeException("没有找到相关商品");
        }

        // 分页查询
        Integer pageNum = searchPageDTO.getPageNum();
        // offset = (pageNum - 1) * pageSize 偏移量
        Integer offset = (pageNum - 1) * searchPageDTO.getPageSize();

        searchPageDTO.setOffset(offset);

        List<ProductItem> productItems = productItemMapper.pageQuery(searchPageDTO);

        if (productItems != null && !productItems.isEmpty()) {
            SearchPageVO searchPageVO = new SearchPageVO();

            searchPageVO.setTotal(total);

            searchPageVO.setGoods(productItems);

            return searchPageVO;
        } else {
            throw new RuntimeException("没有找到相关商品");
        }
    }

    @Override
    public ProductItem getProductById(Long id) {
        ProductItem productItem = new ProductItem();
        productItem.setId(id);
        productItem.setIsActive((byte) 1);
        ProductItem productItem1 = productItemMapper.selectOne(productItem);

        if (productItem1 != null) {
            return productItem1;
        } else {
            throw new RuntimeException("没有找到相关商品");
        }
    }
}
