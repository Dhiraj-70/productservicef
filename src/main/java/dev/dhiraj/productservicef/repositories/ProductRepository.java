package dev.dhiraj.productservicef.repositories;

import dev.dhiraj.productservicef.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product save(Product product);
    List<Product> findAll();
    Product findById(long id);
    List<Product> findAllByTitle(String title);

    @Query("Select p from Product p where p.category.title = :title and p.id = :productId")
    Product getProductWithParticularName(@Param("title") String title,
                                         @Param("productId") Long productId);

}
