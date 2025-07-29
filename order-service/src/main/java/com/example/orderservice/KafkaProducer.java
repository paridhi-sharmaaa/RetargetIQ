package com.example.orderservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class KafkaProducer {

    private static final String TOPIC = "order-events";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendOrder(Order order) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(order);
            kafkaTemplate.send(TOPIC, json);
            System.out.println("✅ Sent order to Kafka: " + json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}