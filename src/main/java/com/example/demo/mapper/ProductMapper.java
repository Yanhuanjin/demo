package com.example.demo.mapper;

import com.example.demo.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author ：Yanhuanjin
 * @version :
 * @date ：Created in 2021/2/24 11:12
 * @description ：Mapper类
 * @modified By：
 */
@Repository
@Mapper
public interface ProductMapper {
    int addProduct(Product product);
    List<Product> getProductList();
    List<Product> getProductListByName(String productName);
    List<Product> getProductListByCondition(@Param("productName") String productName, @Param("productType") int productType);
    int updateProduct(@Param("pro") Product product);
    int deleteProduct(@Param("productId") int productId);
    Product getProductById(int productId);
    List<Map<String, Object>> statisticProductNum();
    List<Product> getProductPageList();
}
