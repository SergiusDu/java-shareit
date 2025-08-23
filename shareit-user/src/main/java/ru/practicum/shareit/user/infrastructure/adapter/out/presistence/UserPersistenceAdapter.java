package ru.practicum.shareit.user.infrastructure.adapter.out.presistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.practicum.shareit.user.infrastructure.adapter.out.presistence.mapper.UserPersistenceMapper;
import ru.practicum.shareit.user.infrastructure.adapter.out.presistence.repository.UserJpaRepository;
import ru.practicum.shareit.user.application.port.out.UserPortOut;
import ru.practicum.shareit.user.domain.model.User;


import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter
    implements UserPortOut {
  private final UserJpaRepository userJpaRepository;
  private final UserPersistenceMapper userPersistenceMapper;

  @Transactional
  @Override
  public User save(User user) {
    return userPersistenceMapper.toUser(userJpaRepository.save(userPersistenceMapper.toUserEntity(user)));
  }

  @Transactional
  @Override
  public void deleteById(long id) {
    userJpaRepository.deleteById(id);
  }

  @Override
  public Optional<User> findById(long id) {
    return userJpaRepository.findById(id)
                            .map(userPersistenceMapper::toUser);
  }

  @Override
  public List<User> findByIds(List<Long> ids) {
    return userJpaRepository.findAllById(ids)
                            .stream()
                            .map(userPersistenceMapper::toUser)
                            .toList();
  }
}
