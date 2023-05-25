package com.springBoot.kafka.practice.Multiple.producer.and.consumer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;


@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic createTopicForGmail(){
        return TopicBuilder.name("topic_gmail")
                .build();
    }
    @Bean
    public NewTopic createTopicForCliq(){
        return TopicBuilder.name("topic_cliq")
                .build();
    }
    @Bean
    public NewTopic createTopicForTelegram(){
        return TopicBuilder.name("topic_telegram")
                .build();
    }
    @Bean
    public NewTopic createTopicForDiscord(){
        return TopicBuilder.name("topic_discord")
                .build();
    }
    @Bean
    public NewTopic createTopicForInstagram(){
        return TopicBuilder.name("topic_instagram")
                .build();
    }


}
