package com.springBoot.kafka.practice.Multiple.producer.and.consumer.service.producer;
import com.springBoot.kafka.practice.Multiple.producer.and.consumer.entity.Cliq;
import com.springBoot.kafka.practice.Multiple.producer.and.consumer.entity.Telegram;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class TelegramProducer {
    private static  final Logger LOGGER = LoggerFactory.getLogger(TelegramProducer.class);

    private KafkaTemplate<String , Telegram> kafkaTemplate;

    public TelegramProducer(KafkaTemplate<String, Telegram> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Telegram data){
        Message message = MessageBuilder.withPayload(data)
                .setHeader(KafkaHeaders.TOPIC , "topic_telegram")
                .build();
        CompletableFuture<SendResult<String, Telegram>> future = kafkaTemplate.send(message);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                LOGGER.info("Sent message=[" + message +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                LOGGER.info("Unable to send message=[" +
                        message + "] due to : " + ex.getMessage());
            }
        });     }
}
