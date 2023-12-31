package com.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义负载均衡规则类
 */

@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule() {
        // 负载均衡规则改为随机
        return new RandomRule();
    }
}
