package com.turkcell.cartservice.kafka;

import io.github.cebo54.events.OrderCreatedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class OrderConsumer {
    @Bean
    public Consumer<OrderCreatedEvent> orderCreatedFunction(){
        return message -> System.out.println(message.getId()+" "+message.getName());
    }


}
