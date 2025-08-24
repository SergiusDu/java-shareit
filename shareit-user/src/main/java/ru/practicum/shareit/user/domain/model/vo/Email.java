package ru.practicum.shareit.user.domain.model.vo;

import java.util.Objects;
import java.util.regex.Pattern;

public record Email(String value) {
  private static final Pattern RX = Pattern.compile("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$");

  public Email {
    Objects.requireNonNull(value, "Email can't be null.");
    if (value.isBlank() || !RX.matcher(value)
                              .matches()) {
      throw new IllegalArgumentException("Invalid email format");
    }
  }
}
