package com.springcloud.service.impl;

import com.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

/**
 * 发送消息接口实现类
 */

@EnableBinding(Source.class) //定义消息的推送管道
public class IMessageProviderImpl implements IMessageProvider {
    @Autowired
    private MessageChannel output; //消息发送管道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());//发送消息
        System.out.println("========serial:" + serial);
        return null;

    }
}

