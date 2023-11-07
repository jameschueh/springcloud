package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients //开启Feign
public class OrderFeignMain82 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain82.class, args);
    }
}

