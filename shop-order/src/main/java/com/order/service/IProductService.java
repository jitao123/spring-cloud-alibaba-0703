package com.order.service;

import com.common.domain.Product;
import com.order.feigncallback.ProductServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.font.CreatedFontTracker;

// Product product = restTemplate.getForObject("http://service-product/product/" + pid, Product.class);

/**
 * @description:  ProductServiceFallback 自定义的发生远程调用异常的时候
 * 自定义de处理办法，不影响其他代码的执行 （实现IProductService 接口）和业务代码进行解耦
 * @author: AT
 * @Date: 2020/8/5 11:42 上午
 */
// 作用，指定nacos下的具体微服务名称
@FeignClient(value = "service-product",fallback = ProductServiceFallback.class)
public interface IProductService {

    /**
     * resultFul 风格定制接口
     * @param pid
     * @return
     */
    @RequestMapping("/product/{pid}")
    Product getProductByPid(@PathVariable Integer pid);

}
