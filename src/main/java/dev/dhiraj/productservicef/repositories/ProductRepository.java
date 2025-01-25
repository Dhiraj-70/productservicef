package dev.dhiraj.productservicef.repositories;

import dev.dhiraj.productservicef.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product save(Product product);
    List<Product> findAll();
    Product findById(long id);
    List<Product> findAllByTitle(String title);
}
