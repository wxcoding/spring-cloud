package com.guanwx.order.bean;

import com.guanwx.product.bean.Product;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: guanwx
 * @CreateTime: 2025-11-05 13:10
 * @Description: 订单实体类
 * @Version: 1.0
 */

@Data
public class Order {

    private Long id;
    private BigDecimal totalAmount;
    private Long userId;
    private String nickname;
    private String address;
    private List<Product> productList;

}
