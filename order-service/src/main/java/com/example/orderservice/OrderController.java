package com.example.orderservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @PostMapping
    public String placeOrder(@RequestBody Order order) {
        kafkaProducer.sendOrder(order);
        return "✅ Order sent to Kafka!";
    }
}