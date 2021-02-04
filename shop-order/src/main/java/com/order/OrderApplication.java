package com.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @author: AT
 * @Date: 2020/7/3 5:47 下午
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@EntityScan("com.common.domain")// 扫描domain 所在的位置
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class);
    }

    @Bean
    @LoadBalanced
    // 添加注解实现自定义的负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
