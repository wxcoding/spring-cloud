package com.guanwx.order.service.imp;

import com.guanwx.order.bean.Order;
import com.guanwx.order.feign.ProductFeignClient;
import com.guanwx.order.service.OrderService;
import com.guanwx.product.bean.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: guanwx
 * @CreateTime: 2025-11-05 13:20
 * @Description: 订单服务
 * @Version: 1.0
 */

@Slf4j
@Service
public class OrderServiceImp implements OrderService {

    @Autowired
    ProductFeignClient productFeignClient;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Order createOrder(Long productId, Long userId) {
        Order order = new Order();
        Product product = productFeignClient.getProductById(productId);
        order.setId(1L);
        // 计算商品总金额（单价乘以商品个数）
        BigDecimal totalAmount = product.getPrice().multiply(new BigDecimal(product.getNum()));
        order.setTotalAmount(totalAmount);
        order.setUserId(userId);
        order.setNickname("测试用户");
        order.setAddress("测试地址");
        order.setProductList(Arrays.asList(product)); // todo 远程查询商品列表
        return order;
    }

    // 1.远程调用 DiscoveryClient（随机）
    private Product getProductFromRemote(Long productId) {
        // 获取远程产品服务的机器
        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
        ServiceInstance serviceInstance = instances.get(0);
        // 获取第一台产品服务的url
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/product/" + productId;
        log.info("远程调用：{}" , url);
        // 通过restTemplate调用远程服务
        return restTemplate.getForObject(url, Product.class);
    }

    // 2.负载均衡远程调用 LoadBalancerClient（轮询）
    private Product getProductFromRemoteWithLoadBalancer(Long productId) {
        // 获取远程产品服务的机器
        ServiceInstance choose = loadBalancerClient.choose("service-product");
        // 获取第一台产品服务的url
        String url = "http://" + choose.getHost() + ":" + choose.getPort() + "/product/" + productId;
        log.info("远程调用：{}" , url);
        // 通过restTemplate调用远程服务
        return restTemplate.getForObject(url, Product.class);
    }

    // 3.基于注解的负载均衡 @LoadBalanced
    private Product getProductFromRemoteWithLoadBalanced(Long productId) {
        String url = "http://service-product/product/" + productId;
        log.info("远程调用：{}" , url);
        // 通过restTemplate调用远程服务
        return restTemplate.getForObject(url, Product.class);
    }

}
