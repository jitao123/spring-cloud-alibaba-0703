package com.order.controller;

import com.alibaba.fastjson.JSON;
import com.common.domain.Order;
import com.common.domain.Product;
import com.order.service.IOrderService;
import com.order.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: AT
 * @Date: 2020/8/5 2:12 下午
 */
//@RestController
@Slf4j
public class OrderController2 {
    //像本地方法一样调用远程服务
    @Autowired
    private IProductService productService;

    @Autowired
    private IOrderService orderService;

    // 使用feign 调用远程服务
    @RequestMapping("/order/prod/{pid}")
//    基于ribbon 实现负载均衡
    public Order order(@PathVariable("pid")Integer pid){
        log.info("接收到--"+pid+"\n");
        log.info("调用微服务--");
        // 使用fegin 调用微服务
        Product product = productService.getProductByPid(pid);

        if (ObjectUtils.isEmpty(product)) throw new RuntimeException("商品对象不能为空！");
        // 模拟调用需要2秒钟
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info(JSON.toJSONString(product));

        Order order = new Order();

        order.setNumber(1);
        order.setUid(1);
        order.setUsername("测试用户");

        order.setPid(pid);
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setNumber(1);

//        为了不产生垃圾数据注释生成订单的方法
//        orderService.creatOrder(order);

        log.info("========"+JSON.toJSONString(order));
        return order;
    }

    @RequestMapping("/order/message")
    public String testMessage(){


        return "测试高并发";
    }
}
