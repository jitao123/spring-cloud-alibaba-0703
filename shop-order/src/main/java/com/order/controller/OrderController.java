package com.order.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.common.domain.Order;
import com.common.domain.Product;
import com.order.service.IOrderService;
import com.order.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

/**
 * @description:
 * @author: AT
 * @Date: 2020/7/3 5:34 下午
 */
//@RestController
@Slf4j
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private IOrderService orderService;
    @Autowired
    private DiscoveryClient discoveryClient;

    //像本地方法一样调用远程服务
    @Autowired
    private IProductService productService;

//
//    @RequestMapping("/order/prod/{pid}")
//    public Order order(@PathVariable("pid")Integer pid){
//        log.info("接收到--"+pid+"\n");
//        log.info("调用微服务--");
//
//
//        // 获取服务的集群list
//        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
//        // 实现算法选择服务器 选择集合里的下标 在最大值内生成整数随机数
//        int index=new Random().nextInt(instances.size());
//        // 因为没有集群所以直接获取第一个
//        ServiceInstance instance = instances.get(index);
//
//        //获取地址和端口号
//        Product product = restTemplate.getForObject("http://"+instance.getHost()+":"+instance.getPort()+"/product/" + pid, Product.class);
//
//        log.info(JSON.toJSONString(product));
//
//        Order order = new Order();
//
//        order.setNumber(1);
//        order.setUid(1);
//        order.setUsername("测试用户");
//
//        order.setPid(pid);
//        order.setPname(product.getPname());
//        order.setPprice(product.getPprice());
//        order.setNumber(1);
//
//        orderService.creatOrder(order);
//
//        log.info("========"+JSON.toJSONString(order));
//        return order;
//    }




//    @RequestMapping("/order/prod/{pid}")
////    基于ribbon 实现负载均衡
//    public Order order(@PathVariable("pid")Integer pid){
//        log.info("接收到--"+pid+"\n");
//        log.info("调用微服务--");
//        //获取地址和端口号
//        Product product = restTemplate.getForObject("http://service-product/product/" + pid, Product.class);
//
//        log.info(JSON.toJSONString(product));
//
//        Order order = new Order();
//
//        order.setNumber(1);
//        order.setUid(1);
//        order.setUsername("测试用户");
//
//        order.setPid(pid);
//        order.setPname(product.getPname());
//        order.setPprice(product.getPprice());
//        order.setNumber(1);
//
//        orderService.creatOrder(order);
//
//        log.info("========"+JSON.toJSONString(order));
//        return order;
//    }


// 使用feign 调用远程服务
    @RequestMapping("/order/prod/{pid}")
//    基于ribbon 实现负载均衡
    public Order order(@PathVariable("pid")Integer pid){
        log.info("接收到--"+pid+"\n");
        log.info("调用微服务--");
        // 使用fegin 调用微服务
        Product product = productService.getProductByPid(pid);

        log.info(JSON.toJSONString(product));

        Order order = new Order();

        order.setNumber(1);
        order.setUid(1);
        order.setUsername("测试用户");

        order.setPid(pid);
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setNumber(1);

        orderService.creatOrder(order);

        log.info("========"+JSON.toJSONString(order));
        return order;
    }



}
