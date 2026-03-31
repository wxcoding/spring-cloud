package com.guanwx.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.guanwx.order.bean.Order;
import com.guanwx.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: guanwx
 * @CreateTime: 2025-11-05 13:02
 * @Description: 订单
 * @Version: 1.0
 */

//@RequestMapping("/api/order")
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    // 创建订单
    @SentinelResource(value = "createOrder")
    @GetMapping("/create")
    public Order createOrder(@RequestParam("userId") Long userId,
                             @RequestParam("productId") Long productId) {
        return orderService.createOrder(productId, userId);
    }

    @GetMapping("/test")
    public String test(){
        System.out.println("test");
        return "test";
    }

}
