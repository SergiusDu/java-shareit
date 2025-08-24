package ru.practicum.shareit.user.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.practicum.shareit.user.application.command.CreateUserCommand;
import ru.practicum.shareit.user.application.command.UpdateUserCommand;
import ru.practicum.shareit.user.application.mapper.UserCommandMapper;
import ru.practicum.shareit.user.application.mapper.UserViewMapper;
import ru.practicum.shareit.user.application.port.in.UserManagementUseCase;
import ru.practicum.shareit.user.application.view.UserView;
import ru.practicum.shareit.user.domain.model.User;
import ru.practicum.shareit.user.domain.model.exception.UserNotFoundException;
import ru.practicum.shareit.user.domain.model.vo.Email;
import ru.practicum.shareit.user.infrastructure.adapter.out.presistence.UserPersistenceAdapter;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService
    implements UserManagementUseCase {
  private final UserPersistenceAdapter userPersistenceAdapter;
  private final UserCommandMapper userCommandMapper;
  private final UserViewMapper userViewMapper;

  @Override
  public UserView createUser(CreateUserCommand command) {
    return userViewMapper.toView(userPersistenceAdapter.save(userCommandMapper.toUser(command)));
  }

  @Override
  @Transactional
  public UserView updateUser(UpdateUserCommand command) {
    User currentUser = userPersistenceAdapter.findById(command.id())
                                             .orElseThrow(() -> new UserNotFoundException(
                                                 "User not found with id: " + command.id()));

    User.UserBuilder userBuilder = currentUser.toBuilder();
    command.name()
           .ifPresent(userBuilder::name);
    command.email()
           .ifPresent((emailStr) -> userBuilder.email(new Email(emailStr)));
    User updatedUser = userBuilder.build();

    return userViewMapper.toView(userPersistenceAdapter.save(updatedUser));
  }

  @Override
  public void deleteUser(long id) {
    userPersistenceAdapter.deleteById(id);
  }

  @Override
  public Optional<UserView> findUserById(long id) {
    return userPersistenceAdapter.findById(id)
                                 .map(userViewMapper::toView);
  }

  @Override
  public List<UserView> findUsersByIds(List<Long> ids) {
    return userPersistenceAdapter.findByIds(ids)
                                 .stream()
                                 .map(userViewMapper::toView)
                                 .toList();
  }
}
