package com.product.service;

import com.common.domain.Product;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: AT
 * @Date: 2020/7/3 5:35 下午
 */
public interface IProductService {

    Product findProdeutByPid(Integer pid);
}
