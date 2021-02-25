package com.example.demo.service;

import com.example.demo.entity.Product;

import java.util.List;

public interface ProductService {
    int addProduct(Product product);
    List<Product> getProductList();
    List<Product> getProductListByName(String productName);
    List<Product> getProductListByCondition(String productName, int productType);
    int updateProduct(Product product);
    int deleteProduct(int productId);
}
