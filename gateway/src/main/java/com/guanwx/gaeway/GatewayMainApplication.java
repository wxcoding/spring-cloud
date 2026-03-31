package com.guanwx.gaeway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: guanwx
 * @CreateTime: 2025-11-13 17:10
 * @Description: 网关
 * @Version: 1.0
 */

@EnableDiscoveryClient
@SpringBootApplication
public class GatewayMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayMainApplication.class,args);

    }
}
