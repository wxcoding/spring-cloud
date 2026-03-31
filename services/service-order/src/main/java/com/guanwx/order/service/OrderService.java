package com.guanwx.order.service;

import com.guanwx.order.bean.Order;

/**
 * @Author: guanwx
 * @CreateTime: 2025-11-05 13:19
 * @Description: 订单服务
 * @Version: 1.0
 */
public interface OrderService {

    Order createOrder(Long productId, Long userId);

}
