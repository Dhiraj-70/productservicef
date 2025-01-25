package dev.dhiraj.productservicef.services;

import dev.dhiraj.productservicef.dtos.CreateProductDto;
import dev.dhiraj.productservicef.exceptions.NotFoundException;
import dev.dhiraj.productservicef.exceptions.ProductNotCreatedException;
import dev.dhiraj.productservicef.models.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(Long id) throws NotFoundException;

    Product deleteProduct(Long id);

    Product createProduct(String title, String description, String category, String ImageUrl, double price) throws ProductNotCreatedException;
}
