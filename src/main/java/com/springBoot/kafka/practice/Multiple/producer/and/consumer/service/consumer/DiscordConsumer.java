package com.springBoot.kafka.practice.Multiple.producer.and.consumer.service.consumer;

import com.springBoot.kafka.practice.Multiple.producer.and.consumer.entity.Discord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class DiscordConsumer {
    private static  final Logger LOGGER = LoggerFactory.getLogger(DiscordConsumer.class);
    @KafkaListener(topics = "topic_discord" , groupId = "myGroup")
    public void consume(Discord data){
        LOGGER.info(String.format("Discord message received  -> %s" , data.toString()));
    }
}
