package dev.dhiraj.productservicef.services;

import dev.dhiraj.productservicef.models.Product;
import dev.dhiraj.productservicef.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {
    private final ProductRepository productRepository;

    public SearchService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<Product> search(String query, int pageNumber, int pageSize, List<String> sortValues) {
        Sort sort = Sort.by("title").descending()
                .and(Sort.by("price").ascending());
        //sorting based on list of sortValue;
//        for(String sortValue : sortValues) {
//            sort = sort.by(sortValue).ascending();
//        }

        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        return productRepository.findByTitleContaining(query, pageable);
    }

}
