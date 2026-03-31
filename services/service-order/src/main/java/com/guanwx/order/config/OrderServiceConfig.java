package com.guanwx.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: guanwx
 * @CreateTime: 2025-11-05 15:39
 * @Description: 商品配置
 * @Version: 1.0
 */

@Configuration
public class OrderServiceConfig {

    @LoadBalanced // 基于注解的：负载均衡
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
