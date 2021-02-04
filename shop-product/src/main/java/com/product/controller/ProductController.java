package com.product.controller;

import com.alibaba.fastjson.JSON;
import com.common.domain.Product;
import com.product.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: AT
 * @Date: 2020/7/3 5:34 下午
 */
@RestController
@Slf4j
public class ProductController {

    @Autowired
    private IProductService productService;

    @RequestMapping("/product/{pid}")
    public Product getProduct(@PathVariable("pid") Integer pid){
        log.info("进行查询： --"+pid+"--号商品");

        Product product= productService.findProdeutByPid(pid);

        log.info("进行查询： --"+ JSON.toJSONString(product)+"--商品");
        return product;
    }

}
