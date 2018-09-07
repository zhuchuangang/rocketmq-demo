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
        // send string
        // Message message = new Message("string-topic", "{\"a\":\"Hello, World!\"}".getBytes());

        OrderPaidEvent event = new OrderPaidEvent("1", BigDecimal.valueOf(10.0));
        Message message = MessageBuilder.of(event).topic("string-topic").build();

        demoProducer.syncSend(message);
    }

}
