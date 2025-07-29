package com.example.orderservice.useractivity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @PostMapping
    public String publishActivity(@RequestBody Map<String, String> payload) {
        String userId = payload.get("userId");
        String action = payload.get("action");
        kafkaProducer.sendActivity(userId, action);
        return "Activity sent to Kafka: " + userId + " -> " + action;
    }

}