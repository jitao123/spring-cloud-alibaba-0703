package com.order.service.impl;

import com.common.domain.Order;
import com.order.dao.IOrderDao;
import com.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @description:
 * @author: AT
 * @Date: 2020/7/3 5:35 下午
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IOrderDao orderDao;

    @Override
    public void creatOrder(Order order) {
        orderDao.save(order);
    }
}
