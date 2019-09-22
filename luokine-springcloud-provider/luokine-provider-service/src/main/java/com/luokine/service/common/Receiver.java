package com.luokine.service.common;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import sun.awt.SunHints;

/**
 * @author: tiantziquan
 * @create: 2019-07-19 17:42
 */
@Component
@RabbitListener(queues = RabbitMQPKG.RabbitMQPKG)
public class Receiver {
    @RabbitHandler
    public void process(String hello) {
        System.out.println("luokine Receiver : " + hello);
    }
}
