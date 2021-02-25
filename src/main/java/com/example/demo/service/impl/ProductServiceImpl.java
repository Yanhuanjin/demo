package com.example.demo.service.impl;

import com.example.demo.entity.Product;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author ：Yanhuanjin
 * @version :
 * @date ：Created in 2021/2/24 11:10
 * @description ：商品服务的实现类
 * @modified By：
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;
    @Override
    public int addProduct(Product product) {
        int count = 0;
        try{
            count = productMapper.addProduct(product);
        }catch (Exception err){
            System.out.println(err);
        }
        return count;
    }

    @Override
    public List<Product> getProductList(){
        List<Product> productList = productMapper.getProductList();
        return productList;
    }

    @Override
    public List<Product> getProductListByName(String productName) {
        List<Product> proList = productMapper.getProductListByName(productName);
        return proList;
    }

    @Override
    public List<Product> getProductListByCondition(String productName, int productType) {
        List<Product> productList = productMapper.getProductListByCondition(productName, productType);
        return productList;
    }

    @Override
    public int updateProduct(Product product){
        int count = 0;
        try {
            count = productMapper.updateProduct(product);
        }catch (Exception err){
            System.out.println(err);
        }
        return count;
    }

    @Override
    public int deleteProduct(int productId){
        int count = 0;
        try{
            count = productMapper.deleteProduct(productId);
        }catch (Exception err){
            System.out.println(err);
        }
        return count;
    }

    @Override
    public Product getProductById(int productId) {
        return productMapper.getProductById(productId);
    }

    @Override
    public List<Map<String, Object>> statisticProductNum() {
        return productMapper.statisticProductNum();
    }

    @Override
    public List<Product> getProductPageList(){
        return productMapper.getProductPageList();
    }
}
