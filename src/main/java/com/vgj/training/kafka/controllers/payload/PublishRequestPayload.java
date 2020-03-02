package com.vgj.training.kafka.controllers.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PublishRequestPayload {

    private String name;
    private String age;
    private String address;

}
