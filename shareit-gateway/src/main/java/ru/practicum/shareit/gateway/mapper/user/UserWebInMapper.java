package ru.practicum.shareit.gateway.mapper.user;

import ru.practicum.shareit.gateway.dto.user.CreateUserDto;
import ru.practicum.shareit.gateway.dto.user.UpdateUserDto;
import org.mapstruct.Mapper;
import ru.practicum.shareit.shared.api.mapping.CentralMappingConfig;
import ru.practicum.shareit.user.application.command.CreateUserCommand;
import ru.practicum.shareit.user.application.command.UpdateUserCommand;


@Mapper(config = CentralMappingConfig.class)
public interface UserWebInMapper {
  CreateUserCommand toCreateUserCommand(CreateUserDto command);

  UpdateUserCommand toUpdateUserCommand(UpdateUserDto updateUserDto, long id);
}
