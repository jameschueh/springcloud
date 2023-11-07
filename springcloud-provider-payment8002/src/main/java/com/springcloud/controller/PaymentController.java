package com.springcloud.controller;

import com.springcloud.entities.CommonResult;
import com.springcloud.entities.Payment;
import com.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverport;

    @Autowired
    private DiscoveryClient discoveryClient;

    //获取服务信息
    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();//得到所有的微服务
        for (String s : services) {
            log.info("********注册到eureka中的服务中有:" + services);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("SPRINGCLOUD-PAYMENT-SERVICE");//的到一个具体微服务的所有实例
        for (ServiceInstance s : instances) {
            log.info("当前服务的实例有" + s.getServiceId() + "\t" + s.getHost() + "\t" + s.getPort() + "\t" + s.getUri());
        }
        return this.discoveryClient;
    }
    //只传给前端CommonResult，不需要前端了解其他的组件
    @PostMapping(value = "/payment/create")
    public CommonResult create(Payment payment){
        int result = paymentService.create(payment);
        log.info("*****插入结果："+result);
        if(result > 0){
            return new CommonResult(200,"插入数据成功, serverport"+ serverport, result);
        }else{
            return new CommonResult(444,"插入数据失败",null);
        }
    }
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****插入结果："+payment);
        if(payment != null){
            return new CommonResult(200,"查询成功, serverport:"+ serverport, payment);
        }else{
            return new CommonResult(444,"没有对应记录,查询ID："+id,null);
        }
    }

    //模拟业务接口延时3秒
    @GetMapping("/payment/feign/timeout")
    public String PaymentFeignTimeOut() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return serverport;
    }
}


