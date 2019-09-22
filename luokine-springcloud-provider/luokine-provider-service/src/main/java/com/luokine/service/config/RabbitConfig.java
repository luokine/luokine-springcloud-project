package com.luokine.service.config;

import com.luokine.service.common.RabbitMQPKG;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: tiantziquan
 * @create: 2019-08-19 18:02
 */
@Configuration
public class RabbitConfig {
    @Bean
    public Queue helloQueue() {
        return new Queue(RabbitMQPKG.RabbitMQPKG);
    }
}
