package com.neobis.project.kotlinfinal.services;

import com.neobis.project.kotlinfinal.entities.ProductEntity;
import com.neobis.project.kotlinfinal.exception.RecordNotFoundException;
import com.neobis.project.kotlinfinal.models.Product;
import com.neobis.project.kotlinfinal.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product getProductById(int productId) throws Exception{
        return new Product(productRepository.findById(productId).orElseThrow(RecordNotFoundException::new));
    }

    public Product getProductBySellerId(int sellerId) throws Exception{
        return new Product(productRepository.findById(sellerId).orElseThrow(RecordNotFoundException::new));
    }


    public Product saveProduct(Product product) {
        ProductEntity saveResult = productRepository.save(product.convertToEntity());
        return new Product(saveResult);
    }

    public void deleteProductById(int productId) {
        productRepository.deleteById(productId);
    }
}
