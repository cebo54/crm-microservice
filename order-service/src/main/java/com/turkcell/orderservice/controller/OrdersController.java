package com.turkcell.orderservice.controller;

import io.github.cebo54.events.OrderCreatedEvent;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class OrdersController {

//    private final ProductClient productClient;
    private final StreamBridge streamBridge;

    public OrdersController( StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @GetMapping
    public String get(){

        //TODO: kafkadan mesaj gönder
        OrderCreatedEvent orderCreatedEvent = new OrderCreatedEvent();
        orderCreatedEvent.setId("abc");
        orderCreatedEvent.setName("name");
        streamBridge.send("orderCreatedFunction-out-0",orderCreatedEvent);
        return "Order Service";
    }
}
