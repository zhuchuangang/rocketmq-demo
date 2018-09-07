package com.aqlu.rocketmq.demo;

import java.math.BigDecimal;

import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aqlu.rocketmq.demo.domain.OrderPaidEvent;
import com.maihaoche.starter.mq.annotation.EnableMQConfiguration;
import com.maihaoche.starter.mq.base.MessageBuilder;

/**
 * ProducerApplication Created by aqlu on 2017/11/16.
 */
@EnableMQConfiguration
@SpringBootApplication
public class ProducerApplication implements CommandLineRunner {

    @Autowired
    private DemoProducer demoProducer;

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // send string 不支持发送字符
        Message message = new Message("string-topic", "Hello, World!".getBytes());
        demoProducer.syncSend(message);

        // send string 支持json字符串
        message = new Message("string-topic", "{\"test\":\"Hello, World!\"}".getBytes());
        demoProducer.syncSend(message);

        // send object
        OrderPaidEvent event = new OrderPaidEvent("1", BigDecimal.valueOf(10.0));
        message = MessageBuilder.of(event).topic("order-paid-topic").build();
        demoProducer.syncSend(message);

        // send object
        event = new OrderPaidEvent("2", BigDecimal.valueOf(20.0));
        message = MessageBuilder.of(event).topic("order-paid-topic").tag("test").build();
        demoProducer.syncSend(message);

        // send object
        event = new OrderPaidEvent("3", BigDecimal.valueOf(30.0));
        message = MessageBuilder.of(event).topic("message-ext-topic").tag("test1").build();
        demoProducer.syncSend(message);
    }

}
