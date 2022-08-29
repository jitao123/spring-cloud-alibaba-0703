package com.order.controller;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: AT
 * @Date: 2020/8/5 2:12 下午
 */
@RestController
@Slf4j
public class OrderController3 {

    // 每秒钟获取10个令牌 每秒放行10个请求
    private RateLimiter rateLimiter=RateLimiter.create(10);

    @RequestMapping("/order/message1")
    public String testMessage1(){
        return "测试高并发";
    }


    @RequestMapping("/order/message2")
    public String testMessage2(){
        return "测试高并发2";
    }


    @RequestMapping("/order/message3")
    public String testMessage3(){
        log.info("等待时间 ～～ "+rateLimiter.acquire());
        System.out.println("处理业务～～～");


        return "测试令牌桶";
    }
}
