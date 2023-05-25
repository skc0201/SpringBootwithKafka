package com.springBoot.kafka.practice.Multiple.producer.and.consumer.service.producer;

import com.springBoot.kafka.practice.Multiple.producer.and.consumer.entity.Cliq;
import com.springBoot.kafka.practice.Multiple.producer.and.consumer.entity.Discord;
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
public class DiscordProducer {
    private static  final Logger LOGGER = LoggerFactory.getLogger(DiscordProducer.class);

    private KafkaTemplate<String , Discord> kafkaTemplate;


    public DiscordProducer(KafkaTemplate<String, Discord> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Discord data){
        Message message = MessageBuilder.withPayload(data)
                .setHeader(KafkaHeaders.TOPIC , "topic_discord")
                .build();
        CompletableFuture<SendResult<String, Discord>> future = kafkaTemplate.send(message);
        future.whenComplete((result, ex) -> {
            System.out.println(result + "result_______++_");
            if (ex == null) {
                LOGGER.info("Sent message=[" + message +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                LOGGER.info("Unable to send message=[" +
                        message + "] due to : " + ex.getMessage());
            }
        });
    }

}
