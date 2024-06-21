package com.jk.wikimedia.consumer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class WIkimediaTopicConfig {
    @Bean
    public NewTopic wikimediaStreanTopic() {
        return TopicBuilder
                .name("wikimedia_stream")
//                .partitions(3)
//                .replicas(3)
                .build();
    }
}
