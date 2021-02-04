package com.order.service;

import com.common.domain.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

// Product product = restTemplate.getForObject("http://service-product/product/" + pid, Product.class);

/**
 * @description:
 * @author: AT
 * @Date: 2020/8/5 11:42 上午
 */
// 作用，指定nacos下的具体微服务名称
@FeignClient("service-product")
public interface IProductService {

    /**
     * resultFul 风格定制接口
     * @param pid
     * @return
     */
    @RequestMapping("/product/{pid}")
    Product getProductByPid(@PathVariable Integer pid);

}
