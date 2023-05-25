package com.springBoot.kafka.practice.Multiple.producer.and.consumer.service.consumer;

import com.springBoot.kafka.practice.Multiple.producer.and.consumer.entity.Gmail;
import com.springBoot.kafka.practice.Multiple.producer.and.consumer.entity.Telegram;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TelegramConsumer {
    private static  final Logger LOGGER = LoggerFactory.getLogger(TelegramConsumer.class);
    @KafkaListener(topics = "topic_telegram" , groupId = "myGroup")
    public void consume(Telegram data){
        LOGGER.info(String.format("Telegram message  received  -> %s" , data.toString()));
    }
}
