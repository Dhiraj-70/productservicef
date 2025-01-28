package dev.dhiraj.productservicef.services;

import dev.dhiraj.productservicef.dtos.CreateProductDto;
import dev.dhiraj.productservicef.dtos.FakeStoreProductDto;
import dev.dhiraj.productservicef.exceptions.NotFoundException;
import dev.dhiraj.productservicef.exceptions.ProductNotCreatedException;
import dev.dhiraj.productservicef.models.Product;
import dev.dhiraj.productservicef.thirdpartyclients.productsservice.fakestore.FakeStoreProductServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service("fakeStoreProductService")
public class FakeStoreProductService implements  ProductService{

    private FakeStoreProductServiceClient fakeStoreProductServiceClient;
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    public FakeStoreProductService(FakeStoreProductServiceClient fakeStoreProductServiceClient, RedisTemplate<String, Object> redisTemplate) {
        this.fakeStoreProductServiceClient = fakeStoreProductServiceClient;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> allProduct = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductServiceClient.getAllProducts()){
            allProduct.add(fakeStoreProductDto.toProduct());
        }
        return allProduct;
    }

    @Override
    public Product getProductById(Long id) throws NotFoundException {
//        Product product = (Product) redisTemplate.opsForValue().get(String.valueOf(id));
//        if (product != null) {
//            return product;
//        }

        FakeStoreProductDto productDto = fakeStoreProductServiceClient.getSingleProduct(id);
//        redisTemplate.opsForValue().set(String.valueOf(id), productDto.toProduct());
        return productDto.toProduct();
    }

    @Override
    public Product deleteProduct(Long id) {
            FakeStoreProductDto productDto = fakeStoreProductServiceClient.deleteProduct(id);
            return productDto.toProduct();
    }

    @Override
    public Product createProduct(String title, String description, String category, String ImageUrl, double price) throws ProductNotCreatedException {
        FakeStoreProductDto productDto = new FakeStoreProductDto();
        productDto.setTitle(title);
        productDto.setDescription(description);
        productDto.setCategory(category);
        productDto.setImage(ImageUrl);
        productDto.setPrice(price);

        fakeStoreProductServiceClient.createProduct(productDto);
        //Always returning null to check throw ProductNotCreatedException.\
        return null;
    }

}
