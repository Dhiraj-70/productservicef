package dev.dhiraj.productservicef.repositories;

import dev.dhiraj.productservicef.models.Category;
import dev.dhiraj.productservicef.repositories.projections.CategoryProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByTitle(String title);
    Category save(Category category);

    @Query(value = "select c.* from Category c where c.id = :id and c.title = :title", nativeQuery = true)
    List<CategoryProjection> checkSomeThingComplex(@Param("id") Long id, @Param("title") String title);

}
