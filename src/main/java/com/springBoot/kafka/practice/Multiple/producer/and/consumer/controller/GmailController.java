package com.springBoot.kafka.practice.Multiple.producer.and.consumer.controller;

import com.springBoot.kafka.practice.Multiple.producer.and.consumer.entity.Discord;
import com.springBoot.kafka.practice.Multiple.producer.and.consumer.entity.Gmail;
import com.springBoot.kafka.practice.Multiple.producer.and.consumer.service.producer.DiscordProducer;
import com.springBoot.kafka.practice.Multiple.producer.and.consumer.service.producer.GmailProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gmail")
public class GmailController {
    @Autowired
    private GmailProducer gmailProducer;


    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody Gmail gmail){
        gmailProducer.sendMessage(gmail);
        return ResponseEntity.ok("Message sent to the kafka topic");
    }
}
