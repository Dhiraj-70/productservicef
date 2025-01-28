package dev.dhiraj.productservicef.controllers;

import dev.dhiraj.productservicef.dtos.CreateProductDto;
import dev.dhiraj.productservicef.exceptions.NotFoundException;
import dev.dhiraj.productservicef.exceptions.ProductNotCreatedException;
import dev.dhiraj.productservicef.models.Product;
import dev.dhiraj.productservicef.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> product = productService.getAllProducts();
        if (product.isEmpty()) {
            return new ResponseEntity<>(
                    product,
                    HttpStatus.NOT_FOUND
            );
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) throws NotFoundException {
        Product product = productService.getProductById(id);
        if (product == null) {
            throw new NotFoundException("Product Does't Exist");
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProductById(@PathVariable Long id) throws NotFoundException {
        return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);
    }

//    @PostMapping
//    public Product createProduct(@RequestBody Product product) {
//        return productService.createProduct(product);
//    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductDto request) throws ProductNotCreatedException {
            Product product = productService.createProduct(request.getTitle(), request.getDescription(), request.getCategory(), request.getImage(), request.getPrice());
        if (product == null) {
            throw new ProductNotCreatedException("Product Not Created");
        }
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }
//    @ExceptionHandler(NotFoundException.class)
//    public ResponseEntity<ErrorDto> handleProductNotFoundException(NotFoundException exception){
//        ErrorDto errorDto = new ErrorDto();
//        errorDto.setMessage(exception.getMessage());
//        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
//    }

}