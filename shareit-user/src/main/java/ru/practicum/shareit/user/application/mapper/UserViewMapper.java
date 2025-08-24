package ru.practicum.shareit.user.application.mapper;

import org.mapstruct.Mapper;
import ru.practicum.shareit.shared.api.mapping.CentralMappingConfig;
import ru.practicum.shareit.user.application.view.UserView;
import ru.practicum.shareit.user.domain.model.User;
import ru.practicum.shareit.user.domain.model.vo.Email;

@Mapper(config = CentralMappingConfig.class)
public interface UserViewMapper {
  UserView toView(User user);

  default String emailToString(Email email) {
    return email.value();
  }
}
