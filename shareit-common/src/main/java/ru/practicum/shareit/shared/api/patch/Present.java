package ru.practicum.shareit.shared.api.patch;

import java.util.Objects;
import java.util.function.Consumer;

public record Present<T>(T value)
    implements FieldUpdate<T> {

  public Present {
    Objects.requireNonNull(value, "Present can't contain null value.");
  }

  @Override
  public void ifPresent(Consumer<? super T> consumer) {
    consumer.accept(value);
  }
}
