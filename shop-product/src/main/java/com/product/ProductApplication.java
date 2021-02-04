package com.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description:
 * @author: AT
 * @Date: 2020/7/3 5:39 下午
 */
@SpringBootApplication
@EnableDiscoveryClient
@EntityScan("com.common.domain")// 扫描domain 所在的位置
public class ProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class);
    }
}
