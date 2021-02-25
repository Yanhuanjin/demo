package com.example.demo.service;

import com.example.demo.entity.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {
    int addProduct(Product product);
    List<Product> getProductList();
    List<Product> getProductListByName(String productName);
    List<Product> getProductListByCondition(String productName, int productType);
    int updateProduct(Product product);
    int deleteProduct(int productId);
    Product getProductById(int productId);
    List<Map<String, Object>> statisticProductNum();
    List<Product> getProductPageList();
}
