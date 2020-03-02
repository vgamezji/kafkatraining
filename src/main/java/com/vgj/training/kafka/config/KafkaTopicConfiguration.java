package com.vgj.training.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfiguration {

    @Value(value = "${app.kafka.topic}")
    private String topic;

    /**
     * This bean register automatically a topic using Spring Kafka library
     */
    @Bean
    public NewTopic topic1() {
        return new NewTopic(topic, 1, (short) 1);
    }

}
