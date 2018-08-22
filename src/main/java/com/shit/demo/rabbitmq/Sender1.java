package com.shit.demo.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("sender1")
public class Sender1 {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String context = "hello " + new Date();
        System.out.println("Sender1 : " + context);
        for(int i=0 ;i<100;i++) {
            this.rabbitTemplate.convertAndSend("hello", context);
        }
    }
}
