package com.springBoot.kafka.practice.Multiple.producer.and.consumer.service.consumer;

import com.springBoot.kafka.practice.Multiple.producer.and.consumer.entity.Discord;
import com.springBoot.kafka.practice.Multiple.producer.and.consumer.entity.Instagram;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class InstagramConsumer {
    private static  final Logger LOGGER = LoggerFactory.getLogger(InstagramConsumer.class);
    @KafkaListener(topics = "topic_instagram" , groupId = "myGroup")
    public void consume(Instagram data){
        LOGGER.info(String.format("Instagram message received  -> %s" , data.toString()));
    }
}
