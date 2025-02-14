package com.turkcell.orderservice.controller;

import com.turkcell.orderservice.client.ProductClient;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class OrdersController {

    private final ProductClient productClient;
    private final StreamBridge streamBridge;

    public OrdersController(ProductClient productClient, StreamBridge streamBridge) {
        this.productClient = productClient;
        this.streamBridge = streamBridge;
    }

    @GetMapping
    public String get(){
        String response = productClient.get();
        System.out.println(response);

        //TODO: kafkadan mesaj gönder

        streamBridge.send("orderCreatedFunction-out-0","message");
        return "Order Service";
    }
}
