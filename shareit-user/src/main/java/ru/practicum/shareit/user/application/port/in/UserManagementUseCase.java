package ru.practicum.shareit.user.application.port.in;

import ru.practicum.shareit.user.application.command.CreateUserCommand;
import ru.practicum.shareit.user.application.command.UpdateUserCommand;
import ru.practicum.shareit.user.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserManagementUseCase {
  User createUser(CreateUserCommand command);

  User updateUser(UpdateUserCommand command);

  void deleteUser(long id);

  Optional<User> findUserById(long id);

  List<User> findUsersByIds(List<Long> ids);
}
