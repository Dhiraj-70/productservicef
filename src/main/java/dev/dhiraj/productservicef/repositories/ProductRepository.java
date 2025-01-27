package dev.dhiraj.productservicef.repositories;

import dev.dhiraj.productservicef.models.Product;
import dev.dhiraj.productservicef.repositories.projections.CategoryProjection;
import dev.dhiraj.productservicef.repositories.projections.ProductProjection;
import dev.dhiraj.productservicef.repositories.projections.ProductWithTitleAndId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Query("select p.title as title, p.id as id from Product p where p.category.id = :catId")
    List<ProductWithTitleAndId> getTitleOfProductsOfGivenCategory(@Param("catId") Long categoryId);

    @Query("select p.title as title, p.description as description from Product p where p.id = :pID")
    List<ProductProjection> getTitleAndDescriptionOfGivenProduct(@Param("pID") Long productId);

    Page<Product> findByTitleContaining(String query, Pageable pageable);
}
