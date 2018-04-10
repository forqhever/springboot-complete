package com.forqhever.springbootcomplete.kafka.web.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaController {

    @RequestMapping("/index")
    public String index(@RequestBody Map<String, Object> msg) {
        return "kafka! Your msg is " + msg;
    }
}
