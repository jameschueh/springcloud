package com.springcloud.service;

import com.springcloud.entities.CommonResult;
import com.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "SPRINGCLOUD-PAYMENT-SERVICE")  //指定调用哪个微服务
public interface PaymentFeignService {

    //调用生产者微服务名称为SPRINGCLOUD-PAYMENT-SERVICE下边的接口
    @GetMapping(value = "/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    //调用生产者微服务名称为SPRINGCLOUD-PAYMENT-SERVICE下边的模拟超时的接口
    @GetMapping("/payment/feign/timeout")
    public String PaymentFeignTimeOut() throws InterruptedException;

}

