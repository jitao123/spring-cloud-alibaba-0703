package com.common.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @description:
 * @author: AT
 * @Date: 2020/5/29 5:40 下午
 */
//商品
@Entity(name = "shop_product" )
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid; // 商品ID
    private String pname; //商品名字
    private Double pprice;//商品价格
    private Integer stock; //库存
}