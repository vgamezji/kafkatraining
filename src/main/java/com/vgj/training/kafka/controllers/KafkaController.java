package com.vgj.training.kafka.controllers;

import com.vgj.training.kafka.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {
    private final Producer producer;

    @Autowired
    public KafkaController(Producer producer) {
        this.producer = producer;
    }

    @GetMapping(value = "/publish")
    public void sendMessageToKafkaTopic(){
        this.producer.sendMessage("Hello!!");
    }

}
