package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.entity.Response;
import com.example.demo.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：Yanhuanjin
 * @version :
 * @date ：Created in 2021/2/24 13:03
 * @description ：Product控制类，调用服务，处理业务逻辑
 * @modified By：
 */
@RestController
public class ProductController {
    @Autowired
    ProductService productService;
    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public Response addProduct(@RequestBody Product product){
        if (product.getProductName()!=null && product.getProductPrice()!=0 && product.getProductType()!=0
        && product.getProductDes()!=null && product.getProductImg()!=null){
            int count = productService.addProduct(product);
            Response response;
            if(count>0){
                response = new Response("添加成功", 1, true);
            }else{
                response = new Response("添加失败", -1, false);
            }
            return  response;
        }else{
            Response response = new Response("有参数为空", -1, false);
            return response;
        }
    }

    @RequestMapping(value = "getProductList", method = RequestMethod.POST)
    public Response getProductList(){
        Response response = new Response();
        List<Product> productList = productService.getProductList();
        response.setResponse("查询成功", 1, true, productList);
        return response;
    }

    @RequestMapping(value = "/getProductListByName", method = RequestMethod.POST)
    public Response getProductListByName(@RequestBody Map<String, String> product){ // 也可以用@RequestParam，两者区别在哪
        Response response = new Response();
        String productName = product.get("productName");
        List<Product> productList = productService.getProductListByName(productName);
        if (productList.size()>0){
            response.setResponse("查询成功", 1,true, productList);
        }else{
            response.setResponse("未查询到", -1, false, productList);
        }
        return response;
    }

    @RequestMapping(value = "/getProductListByCondition", method = RequestMethod.POST)
    public Response getProductListByCondition(@RequestBody Product product){
        String productName = product.getProductName();
        int productType = product.getProductType();
        Response response = new Response();
        List<Product> productList = productService.getProductListByCondition(productName, productType);
        if (productList.size()>0) {
            response.setResponse("查询成功", 1, true, productList);
        }else {
            response.setResponse("查询失败，未查询到数据", -1, false,productList);
        }
        return response;
    }

    @RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
    public Response updateProduct(@RequestBody Product product){
        int productId = product.getProductId();
        int count = productService.updateProduct(product);
        Response response;
        if (productId!=0){
            if (count > 0){
                response = new Response("更新成功", 1, true);
            }else {
                response = new Response("更新失败", -1, false);
            }
        }else {
            response = new Response("请传入商品id", -1, false);

        }
        return response;
    }

    @RequestMapping(value = "/deleteProduct", method = RequestMethod.POST)
    public Response deleteProduct(@RequestBody Product product) {
        int productId = product.getProductId();
        if (productId != 0) {
            int count = productService.deleteProduct(productId);
            Response response;
            if (count > 0) {
                response = new Response("删除成功", 1, true);
            } else {
                response = new Response("删除失败", -1, false);
            }
            return response;
        }else{
            Response response = new Response("删除失败", -1, false);
            return response;
        }
    }

    @RequestMapping(value = "/getProductById", method = RequestMethod.POST)
    public Response getProductById(@RequestParam("productId") Integer productId){
        Response response = new Response();
        Product product = productService.getProductById(productId);
        if(null != product){
            response.setResponse("查询成功", 1, true, product);
        }else{
            response.setResponse("未查询到数据", 1, true, null);
        }
        return response;
    }

    @RequestMapping(value = "/statisticProductNum", method = RequestMethod.POST)
    public Response statisticProductNum() {
        Response response = new Response();
        List<Map<String, Object>> resList = productService.statisticProductNum();
        response.setResponse("查询成功", 1, true, resList);
        return response;
    }

    @RequestMapping(value = "/getProductPageList", method = RequestMethod.GET)
    public Response getProductPageList(@RequestParam("pageNum") Integer pageNum,
                                       @RequestParam("pageSize") Integer pageSize){
        // 借助pagehelper插件开启分页
        // 下面这行代码的位置不能随便放，
        // pagehelper会对此代码之后的第一个查询进行分页，
        // 如果涉及多个查询语句的业务代码，注意此行代码的摆放位置
        PageHelper.startPage(pageNum, pageSize);
        List<Product> list = productService.getProductPageList();
        // 组装分页数据，主要包含分页列表数据及总记录数
        Map<String, Object> map = new HashMap<>();
        map.put("list", list);
        map.put("total", new PageInfo<>(list).getTotal());
        Response response = new Response();
        response.setResponse("查询成功", 1, true, map);
        return response;
    }
}
