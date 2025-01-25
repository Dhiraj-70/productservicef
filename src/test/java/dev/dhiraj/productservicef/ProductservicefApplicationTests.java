package dev.dhiraj.productservicef;

import dev.dhiraj.productservicef.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

}
