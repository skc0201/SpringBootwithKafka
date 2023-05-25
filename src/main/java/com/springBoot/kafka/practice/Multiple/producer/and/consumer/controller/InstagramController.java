package com.springBoot.kafka.practice.Multiple.producer.and.consumer.controller;

import com.springBoot.kafka.practice.Multiple.producer.and.consumer.entity.Gmail;
import com.springBoot.kafka.practice.Multiple.producer.and.consumer.entity.Instagram;
import com.springBoot.kafka.practice.Multiple.producer.and.consumer.service.producer.GmailProducer;
import com.springBoot.kafka.practice.Multiple.producer.and.consumer.service.producer.InstagramProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/instagram")
public class InstagramController {
    @Autowired
    private InstagramProducer instagramProducer;


    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody Instagram instagram){
        instagramProducer.sendMessage(instagram);
        return ResponseEntity.ok("Message sent to the kafka topic");
    }
}
