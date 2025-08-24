package ru.practicum.shareit.user.infrastructure.adapter.out.presistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.practicum.shareit.shared.api.mapping.CentralMappingConfig;
import ru.practicum.shareit.user.domain.model.vo.Email;
import ru.practicum.shareit.user.infrastructure.adapter.out.presistence.model.UserEntity;
import ru.practicum.shareit.user.domain.model.User;


@Mapper(config = CentralMappingConfig.class)
public interface UserPersistenceMapper {
  @Mapping(target = "id", source = "userId")
  User toUser(UserEntity user);

  @Mapping(target = "userId", source = "id")
  UserEntity toUserEntity(User user);

  default Email toEmail(String raw) {
    if (raw == null) {
      return null;
    }
    return new Email(raw);
  }

  default String toString(Email email) {
    if (email == null) {
      return null;
    }
    return email.value();
  }
}
