package com.aqlu.rocketmq.demo.consumer;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.aqlu.rocketmq.demo.domain.OrderPaidEvent;
import com.maihaoche.starter.mq.annotation.MQConsumer;
import com.maihaoche.starter.mq.base.AbstractMQPushConsumer;

import lombok.extern.slf4j.Slf4j;

/**
 * StringConsumer Created by aqlu on 2017/11/16.
 */
@Slf4j
@Service
@MQConsumer(topic = "order-paid-topic", consumerGroup = "order-paid-consumer")
public class OrderPaidEventConsumer extends AbstractMQPushConsumer<OrderPaidEvent> {

    @Override
    public boolean process(OrderPaidEvent message, Map extMap) {
        // extMap 中包含messageExt中的属性和message.properties中的属性
        System.out.println(message);
        return true;
    }
}
