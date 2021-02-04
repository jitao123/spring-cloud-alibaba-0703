package com.product.service.impl;

import com.common.domain.Product;
import com.product.dao.IProductDao;
import com.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @description:
 * @author: AT
 * @Date: 2020/7/3 5:35 下午
 */
@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductDao productDao;

    @Override
    public Product findProdeutByPid(Integer pid) {
        return productDao.findById(pid).get();

    }
}
