package com.springBoot.kafka.practice.Multiple.producer.and.consumer.service.consumer;


import com.springBoot.kafka.practice.Multiple.producer.and.consumer.entity.Cliq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CliqConsumer {

    private static  final Logger LOGGER = LoggerFactory.getLogger(CliqConsumer.class);
    @KafkaListener(topics = "topic_cliq" , groupId = "myGroup")
    public void consume(Cliq data){
        LOGGER.info(String.format("Cliq message received  -> %s" , data.toString()));
    }
}
