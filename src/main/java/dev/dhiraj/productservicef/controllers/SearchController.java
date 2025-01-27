package dev.dhiraj.productservicef.controllers;

import dev.dhiraj.productservicef.dtos.SearchRequestDto;
import dev.dhiraj.productservicef.models.Product;
import dev.dhiraj.productservicef.services.SearchService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {
    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }
    @PostMapping("/search")
    public Page<Product> search(@RequestBody SearchRequestDto searchReq){
        return searchService.search(searchReq.getQuery(), searchReq.getPageNumber(), searchReq.getPageSize(), searchReq.getSortValue());
    }
}
