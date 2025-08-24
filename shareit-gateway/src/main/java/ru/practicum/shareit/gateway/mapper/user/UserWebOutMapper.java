package ru.practicum.shareit.gateway.mapper.user;

import org.mapstruct.Mapper;
import ru.practicum.shareit.gateway.dto.user.UserResponse;
import ru.practicum.shareit.shared.api.mapping.CentralMappingConfig;
import ru.practicum.shareit.user.application.view.UserView;


@Mapper(config = CentralMappingConfig.class)
public interface UserWebOutMapper {
  UserResponse toUserResponse(UserView user);
}
