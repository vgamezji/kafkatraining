package com.vgj.training.kafka.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class UserDTO {

    private String name;
    private String age;
    private String address;

}
