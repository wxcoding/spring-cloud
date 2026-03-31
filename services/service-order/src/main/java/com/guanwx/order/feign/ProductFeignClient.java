package com.guanwx.order.feign;

import com.guanwx.product.bean.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: guanwx
 * @CreateTime: 2025-11-11 21:00
 * @Description: Feign远程调用
 * @Version: 1.0
 */

@FeignClient(value = "service-product")
public interface ProductFeignClient {

    @GetMapping("/product/{id}")
    Product getProductById(@PathVariable("id") Long id);

}
