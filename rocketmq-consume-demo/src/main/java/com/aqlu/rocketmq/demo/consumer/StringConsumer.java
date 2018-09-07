package com.aqlu.rocketmq.demo.consumer;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.maihaoche.starter.mq.annotation.MQConsumer;
import com.maihaoche.starter.mq.base.AbstractMQPushConsumer;

import lombok.extern.slf4j.Slf4j;

/**
 * StringConsumer Created by aqlu on 2017/11/16.
 */
@Slf4j
@Service
@MQConsumer(topic = "string-topic", consumerGroup = "string_consumer")
public class StringConsumer extends AbstractMQPushConsumer {

    @Override
    public boolean process(Object message, Map extMap) {
        // extMap 中包含messageExt中的属性和message.properties中的属性
        System.out.println(message);
        return true;
    }
}
