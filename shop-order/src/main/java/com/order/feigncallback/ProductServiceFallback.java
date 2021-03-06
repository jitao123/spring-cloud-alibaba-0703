package com.order.feigncallback;

import com.common.domain.Product;
import com.order.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @description: 结合 sentinel 和feign 实现自定义调用方法发生异常时候处理方法
 * @author: AT
 * @Date: 2021/3/6 1:39 下午
 */
@Component
@Slf4j
public class ProductServiceFallback  implements IProductService {


    /**
     * resultFul 风格定制接口
     *
     * @param pid
     * @return
     */
    @Override
    public Product getProductByPid(Integer pid) {
        log.error("通过商品ID获取商品对象失败～～～～商品ID为 ：  "+pid);
        return new Product();
    }
}
