package com.springBoot.kafka.practice.Multiple.producer.and.consumer.controller;

import com.springBoot.kafka.practice.Multiple.producer.and.consumer.entity.Instagram;
import com.springBoot.kafka.practice.Multiple.producer.and.consumer.entity.Telegram;
import com.springBoot.kafka.practice.Multiple.producer.and.consumer.service.producer.InstagramProducer;
import com.springBoot.kafka.practice.Multiple.producer.and.consumer.service.producer.TelegramProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/telegram")
public class TelegramController {
    @Autowired
    private TelegramProducer telegramProducer;

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody Telegram telegram){
        telegramProducer.sendMessage(telegram);
        return ResponseEntity.ok("Message sent to the kafka topic");
    }
}
