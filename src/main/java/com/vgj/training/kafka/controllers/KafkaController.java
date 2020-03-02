package com.vgj.training.kafka.controllers;

import com.vgj.training.kafka.controllers.payload.PublishRequestPayload;
import com.vgj.training.kafka.mappers.AppMapper;
import com.vgj.training.kafka.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final Producer producer;
    private final AppMapper mapper;

    @Autowired
    public KafkaController(Producer producer, AppMapper mapper) {
        this.producer = producer;
        this.mapper = mapper;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestBody PublishRequestPayload user) {
        this.producer.sendMessage(mapper.mapPublishRequestPayloadToUserDTO(user));
    }

}
