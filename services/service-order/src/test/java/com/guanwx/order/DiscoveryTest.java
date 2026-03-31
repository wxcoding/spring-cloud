package com.guanwx.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.util.List;

@SpringBootTest
public class DiscoveryTest {

    @Autowired
    DiscoveryClient discoveryClient;

    @Test
    public void test() {
        System.out.printf("服务列表：%n");
        discoveryClient.getServices().forEach(System.out::println);
        for(String service : discoveryClient.getServices()) {
            System.out.printf("%s%n", service);
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for(ServiceInstance instance : instances) {
                System.out.printf("%s%n", instance.getHost());
                System.out.printf("%s%n", instance.getPort());
            }
        }
        discoveryClient.getServices().forEach(System.out::println);

    }
}
