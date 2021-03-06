package com.aqlu.rocketmq.demo.consumer;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.maihaoche.starter.mq.annotation.MQConsumer;
import com.maihaoche.starter.mq.base.AbstractMQPushConsumer;

import lombok.extern.slf4j.Slf4j;

/**
 * com.maihaoche的rocketmq插件不支持直接接受String类型，com.maihaoche.starter.mq.base.AbstractMQConsumer.parseMessage方法没有
 * 对String类型进行判断
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
