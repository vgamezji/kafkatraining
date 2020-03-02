package com.vgj.training.kafka.consumer;

import com.vgj.training.kafka.avro.AvroUser;
import com.vgj.training.kafka.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.ConversionService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Consumer {

    private static final String USER_TOPIC = "users";

    private final Logger logger = LoggerFactory.getLogger(Consumer.class);
    private final ConversionService conversionService;

    @KafkaListener(topics = USER_TOPIC)
    public void consume(ConsumerRecord<String, AvroUser> record) {
        UserDTO value = conversionService.convert(record.value(), UserDTO.class);
        logger.info(String.format("$$ -> Consumed Message -> %s", value.getName()));
    }


}
