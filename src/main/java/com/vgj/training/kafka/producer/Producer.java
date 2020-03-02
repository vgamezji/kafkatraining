package com.vgj.training.kafka.producer;

import com.vgj.training.kafka.avro.AvroUser;
import com.vgj.training.kafka.dto.UserDTO;
import com.vgj.training.kafka.mappers.AppMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
@RequiredArgsConstructor
public class Producer {

    private final KafkaTemplate<String, AvroUser> kafkaTemplate;
    private final AppMapper mapper;

    @Value(value = "${app.kafka.topic}")
    private String topic;

    public void sendMessage(UserDTO userData) {
        ListenableFuture<SendResult<String, AvroUser>> future = kafkaTemplate
            .send(topic, userData.getName(), mapper.mapUserDTOtoAvroUser(userData));
        future.addCallback(new ListenableFutureCallback<SendResult<String, AvroUser>>() {

            @Override
            public void onSuccess(SendResult<String, AvroUser> result) {
                System.out.println("Sent message=[" + result.getProducerRecord().value() +
                    "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }

            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to send message=["
                    + userData.toString() + "] due to : " + ex.getMessage());
            }
        });
    }
}
