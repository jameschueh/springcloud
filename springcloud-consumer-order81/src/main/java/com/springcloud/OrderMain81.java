package com.springcloud;

import com.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
//name为生产者服务的服务名称  configuration为配置类的类名
@RibbonClient(name = "SPRINGCLOUD-PAYMENT-SERVICE", configuration = MySelfRule.class)
public class OrderMain81 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain81.class,args);
    }
}
