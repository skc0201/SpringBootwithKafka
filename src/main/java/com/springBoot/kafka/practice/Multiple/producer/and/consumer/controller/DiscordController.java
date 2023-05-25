package com.springBoot.kafka.practice.Multiple.producer.and.consumer.controller;

import com.springBoot.kafka.practice.Multiple.producer.and.consumer.entity.Cliq;
import com.springBoot.kafka.practice.Multiple.producer.and.consumer.entity.Discord;
import com.springBoot.kafka.practice.Multiple.producer.and.consumer.service.producer.CliqProducer;
import com.springBoot.kafka.practice.Multiple.producer.and.consumer.service.producer.DiscordProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/discord")
public class DiscordController {
    @Autowired
    private DiscordProducer discordProducer;


    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody Discord discord){
        discordProducer.sendMessage(discord);
        return ResponseEntity.ok("Message sent to the kafka topic");
    }
}
