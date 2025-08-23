package ru.practicum.shareit.gateway.mapper.user;

import org.mapstruct.Mapper;
import ru.practicum.shareit.shared.api.mapping.CentralMappingConfig;
import ru.practicum.shareit.user.domain.model.vo.Email;

@Mapper(config = CentralMappingConfig.class)
public interface EmailWebMapper {
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
