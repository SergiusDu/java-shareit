package ru.practicum.shareit.user.application.port.out;

import ru.practicum.shareit.user.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserPortOut {
  User save(User user);

  void deleteById(long id);

  Optional<User> findById(long id);

  List<User> findByIds(List<Long> ids);
}
