package com.zxyd.controller;

import com.zxyd.pojo.dto.SearchPageDTO;
import com.zxyd.pojo.vo.SearchPageVO;
import com.zxyd.pojo.vo.SearchVO;
import com.zxyd.result.Result;
import com.zxyd.service.ProductItemService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author LJH
 * @Date 2024/9/1 18:20
 * @Version 1.0
 * @Description:
 */
@RestController
@Slf4j
public class SearchController {
    @Resource
    private ProductItemService productItemService;

    @GetMapping("/search/getSearchList")
    public Result<List<SearchVO>> searchByKeyword(@RequestParam(value = "keyword") String keyword) {
        log.info("searchByKeyword：{}", keyword);
        List<SearchVO> list = productItemService.queryByKeyword(keyword);
        return Result.success(list);
    }

    @GetMapping("/search/getSearchPageList")
    public Result<SearchPageVO> searchPage(@RequestParam(value = "query", required = false) String query,
                                           @RequestParam(value = "cid", required = false) Long cid,
                                           @RequestParam(value = "pageNum", required = false) Integer pageNum,
                                           @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        SearchPageDTO searchPageDTO = new SearchPageDTO();
        searchPageDTO.setKeyword(query);
        searchPageDTO.setCid(cid);
        searchPageDTO.setPageNum(pageNum);
        searchPageDTO.setPageSize(pageSize);

        log.info("searchPage：{}", searchPageDTO);
        SearchPageVO searchPageVO = productItemService.searchPageList(searchPageDTO);
        return Result.success(searchPageVO);
    }
}
