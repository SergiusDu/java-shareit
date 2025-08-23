package ru.practicum.shareit.user.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.practicum.shareit.shared.api.mapping.CentralMappingConfig;
import ru.practicum.shareit.user.application.command.CreateUserCommand;
import ru.practicum.shareit.user.domain.model.User;
import ru.practicum.shareit.user.domain.model.vo.Email;

@Mapper(config = CentralMappingConfig.class)
public interface UserCommandMapper {

  @Mapping(target = "id", constant = "0L")
  User toUser(CreateUserCommand command);

  default Email toEmail(String email) {
    if (email == null || email.isBlank())
      return null;
    return new Email(email);
  }
}
