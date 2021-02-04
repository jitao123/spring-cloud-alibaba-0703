package com.product.dao;

import com.common.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @description:
 * @author: AT
 * @Date: 2020/7/3 5:36 下午
 */
@Repository
public interface IProductDao extends JpaRepository<Product,Integer> {
}
