package com.guanwx.product.controller;

import com.guanwx.product.bean.Product;
import com.guanwx.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        log.info("被远程调用...............");
        return productService.getProductById(id);
    }
}
