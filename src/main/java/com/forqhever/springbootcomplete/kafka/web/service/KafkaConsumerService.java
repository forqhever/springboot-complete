package com.forqhever.springbootcomplete.kafka.web.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener(topics = "test-topic")
    public void receive(ConsumerRecord<String, String> consumerRecord) {
        System.out.println("receive: " + consumerRecord);
        System.out.println("topic: " + consumerRecord.topic());
        System.out.println("key: " + consumerRecord.key());
        System.out.println("value: " + consumerRecord.value());
    }
}
