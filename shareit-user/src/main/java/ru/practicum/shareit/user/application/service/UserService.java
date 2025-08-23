package ru.practicum.shareit.user.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.practicum.shareit.user.infrastructure.adapter.out.presistence.UserPersistenceAdapter;
import ru.practicum.shareit.user.application.command.CreateUserCommand;
import ru.practicum.shareit.user.application.command.UpdateUserCommand;
import ru.practicum.shareit.user.application.mapper.UserCommandMapper;
import ru.practicum.shareit.user.application.port.in.UserManagementUseCase;
import ru.practicum.shareit.user.domain.model.User;
import ru.practicum.shareit.user.domain.model.exception.UserNotFoundException;
import ru.practicum.shareit.user.domain.model.vo.Email;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService
    implements UserManagementUseCase {
  private final UserPersistenceAdapter userPersistenceAdapter;
  private final UserCommandMapper userCommandMapper;

  @Override
  public User createUser(CreateUserCommand command) {
    return userPersistenceAdapter.save(userCommandMapper.toUser(command));
  }

  @Override
  @Transactional
  public User updateUser(UpdateUserCommand command) {
    User currentUser = findUserById(command.id()).orElseThrow(() -> new UserNotFoundException(
        "User not found with id: " + command.id()));

    User.UserBuilder userBuilder = currentUser.toBuilder();
    command.name()
           .ifPresent(userBuilder::name);
    command.email()
           .ifPresent((emailStr) -> userBuilder.email(new Email(emailStr)));
    User updatedUser = userBuilder.build();

    return userPersistenceAdapter.save(updatedUser);
  }

  @Override
  public void deleteUser(long id) {
    userPersistenceAdapter.deleteById(id);
  }

  @Override
  public Optional<User> findUserById(long id) {
    return userPersistenceAdapter.findById(id);
  }

  @Override
  public List<User> findUsersByIds(List<Long> ids) {
    return userPersistenceAdapter.findByIds(ids);
  }
}
