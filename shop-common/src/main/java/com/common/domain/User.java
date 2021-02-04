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
 * @Date: 2020/5/29 11:56 上午
 */
//FJF
@Entity(name = "shop_user")
@Data
public class User {
    @Id
    //数据库自增
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 主键
    private Integer uid;
    //用户名
    private String username;
    //密码
    private String password;
    //电话
    private String telephone;
}