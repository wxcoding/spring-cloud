package com.guanwx.product.service.imp;

import com.guanwx.product.bean.Product;
import com.guanwx.product.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductServiceImp implements ProductService {

    @Override
    public Product getProductById(Long id) {
        Product product = new Product();
        product.setId(id);
        product.setProductName("商品1");
        product.setPrice(new BigDecimal(100));
        product.setNum(10);
        return product;
    }
}
