package dev.dhiraj.productservicef;

import dev.dhiraj.productservicef.repositories.ProductRepository;
import dev.dhiraj.productservicef.repositories.projections.ProductProjection;
import dev.dhiraj.productservicef.repositories.projections.ProductWithTitleAndId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProductservicefApplicationTests {

    @Autowired
    private ProductRepository productRepository;
    @Test
    void contextLoads() {
    }

    @Test
    void testingQueries(){
        productRepository.findAllByTitle("New Laptops");
        //select p1_0.id,p1_0.category_id,p1_0.created_at,
        // p1_0.description,p1_0.image,p1_0.is_deleted,
        // p1_0.last_updated_at,p1_0.price,p1_0.title
        // from product p1_0 where p1_0.title=?
    }

    @Test
    void testingQueries2(){
        System.out.println("getProductWithParticularName....");
        productRepository.getProductWithParticularName("Electronics", 2L);
        System.out.println("done....");
    }

    @Test
    void projectionQueries(){
        List<ProductWithTitleAndId> productWithTitleAndIds = productRepository.getTitleOfProductsOfGivenCategory(2L);
        System.out.println(productWithTitleAndIds.get(0).getTitle());
        System.out.println(productWithTitleAndIds.get(0).getId());
    }

    @Test
    void projectProjectionQueries(){
        List<ProductProjection> prodProj = productRepository.getTitleAndDescriptionOfGivenProduct(1L);
        System.out.println(prodProj.get(0).getDescription());
        System.out.println(prodProj.get(0).getTitle());
    }
}
