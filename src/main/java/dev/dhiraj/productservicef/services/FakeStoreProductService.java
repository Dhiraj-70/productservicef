package dev.dhiraj.productservicef.services;

import dev.dhiraj.productservicef.dtos.CreateProductDto;
import dev.dhiraj.productservicef.dtos.FakeStoreProductDto;
import dev.dhiraj.productservicef.exceptions.NotFoundException;
import dev.dhiraj.productservicef.exceptions.ProductNotCreatedException;
import dev.dhiraj.productservicef.models.Product;
import dev.dhiraj.productservicef.thirdpartyclients.productsservice.fakestore.FakeStoreProductServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class FakeStoreProductService implements  ProductService{

    private FakeStoreProductServiceClient fakeStoreProductServiceClient;

    @Autowired
    public FakeStoreProductService(FakeStoreProductServiceClient fakeStoreProductServiceClient) {
        this.fakeStoreProductServiceClient = fakeStoreProductServiceClient;
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
        FakeStoreProductDto productDto = fakeStoreProductServiceClient.getSingleProduct(id);
        return productDto.toProduct();
    }

    @Override
    public Product deleteProduct(Long id) {
            FakeStoreProductDto productDto = fakeStoreProductServiceClient.deleteProduct(id);
            return productDto.toProduct();
    }

    @Override
    public Product createProduct(CreateProductDto product) throws ProductNotCreatedException {
        fakeStoreProductServiceClient.createProduct(product);
        //Always returning null to check throw ProductNotCreatedException.\
        return null;
    }

}
