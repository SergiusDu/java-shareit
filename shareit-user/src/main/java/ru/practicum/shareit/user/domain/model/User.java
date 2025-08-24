package ru.practicum.shareit.user.domain.model;

import lombok.Builder;
import ru.practicum.shareit.user.domain.model.vo.Email;

import java.util.Objects;

@Builder(toBuilder = true)
public record User(long id,
                   String name,
                   Email email) {
  public User {
    Objects.requireNonNull(name, "Name can't be null.");
    Objects.requireNonNull(email, "Email can't be null.");
    if (name.isBlank())
      throw new IllegalArgumentException("Name can't be empty");
  }
}
