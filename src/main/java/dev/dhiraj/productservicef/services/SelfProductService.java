package dev.dhiraj.productservicef.services;

import dev.dhiraj.productservicef.dtos.CreateProductDto;
import dev.dhiraj.productservicef.exceptions.NotFoundException;
import dev.dhiraj.productservicef.exceptions.ProductNotCreatedException;
import dev.dhiraj.productservicef.models.Category;
import dev.dhiraj.productservicef.models.Product;
import dev.dhiraj.productservicef.repositories.CategoryRepository;
import dev.dhiraj.productservicef.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductService")
public class SelfProductService implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Product createProduct(String title, String description, String category, String ImageUrl, double price) throws ProductNotCreatedException {
        Product product1 = new Product();
        product1.setTitle(title);
        product1.setDescription(description);
        product1.setPrice(price);
        product1.setImage(ImageUrl);

        Category category1 = categoryRepository.findByTitle(category);
        if (category1 == null) {
            category1 = new Category();
            category1.setTitle(category);
        }
        product1.setCategory(category1);
        Product productDet = productRepository.save(product1);
        return productDet;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product getProductById(Long id) throws NotFoundException {
        return null;
    }

    @Override
    public Product deleteProduct(Long id) {
        return null;
    }
}
