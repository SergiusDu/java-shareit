package ru.practicum.shareit.user.application.port.in;

import ru.practicum.shareit.user.application.command.CreateUserCommand;
import ru.practicum.shareit.user.application.command.UpdateUserCommand;
import ru.practicum.shareit.user.application.view.UserView;

import java.util.List;
import java.util.Optional;

public interface UserManagementUseCase {
  UserView createUser(CreateUserCommand command);

  UserView updateUser(UpdateUserCommand command);

  void deleteUser(long id);

  Optional<UserView> findUserById(long id);

  List<UserView> findUsersByIds(List<Long> ids);
}
