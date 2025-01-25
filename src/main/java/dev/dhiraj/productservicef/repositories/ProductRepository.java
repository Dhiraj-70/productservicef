package dev.dhiraj.productservicef.repositories;

import dev.dhiraj.productservicef.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product save(Product product);
}
