package com.springBoot.kafka.practice.Multiple.producer.and.consumer.service.consumer;

import com.springBoot.kafka.practice.Multiple.producer.and.consumer.entity.Discord;
import com.springBoot.kafka.practice.Multiple.producer.and.consumer.entity.Gmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class GmailConsumer {
    private static  final Logger LOGGER = LoggerFactory.getLogger(GmailConsumer.class);
    @KafkaListener(topics = "topic_gmail" , groupId = "myGroup")
    public void consume(Gmail data){
        LOGGER.info(String.format("Gmail  received  -> %s" , data.toString()));
    }
}
