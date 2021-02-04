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
 * @Date: 2020/5/29 5:43 下午
 */
@Entity (name = "shop_order" )
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oid;//主键Èid

    private Integer uid; //用户id
    private String username; //用户名

    private Integer pid;// 商品ID
    private String pname;//商品名字
    private Double pprice;//商品价格

    private Integer number; //购买数量
}
