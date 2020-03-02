package com.vgj.training.kafka.mappers;

import com.vgj.training.kafka.avro.AvroUser;
import com.vgj.training.kafka.controllers.payload.PublishRequestPayload;
import com.vgj.training.kafka.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AppMapper {

    UserDTO mapPublishRequestPayloadToUserDTO(PublishRequestPayload source);

    AvroUser mapUserDTOtoAvroUser(UserDTO source);
}
