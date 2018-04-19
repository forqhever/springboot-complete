package com.forqhever.springbootcomplete.kafka.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaController {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @RequestMapping("/index")
    public String index(@RequestBody Map<String, Object> msg) {
        return "kafka! Your msg is " + msg;
    }

    @RequestMapping("/send")
    public String kafkaSendTest() {
        try {
            kafkaTemplate.send("test-topic", "key", "success!");
            return "send successfully!";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "send failed!";
    }
}
