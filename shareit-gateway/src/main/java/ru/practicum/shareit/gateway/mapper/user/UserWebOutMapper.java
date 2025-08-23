package ru.practicum.shareit.gateway.mapper.user;

import ru.practicum.shareit.gateway.dto.user.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.practicum.shareit.shared.api.mapping.CentralMappingConfig;
import ru.practicum.shareit.user.domain.model.User;


@Mapper(config = CentralMappingConfig.class, uses = EmailWebMapper.class)
public interface UserWebOutMapper {
  @Mapping(target = "email", source = "email")
  UserResponse toUserResponse(User user);
}
