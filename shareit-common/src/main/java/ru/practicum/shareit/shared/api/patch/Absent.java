package ru.practicum.shareit.shared.api.patch;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;

@Slf4j
@SuppressWarnings("rawtypes")
public final class Absent<T> implements FieldUpdate<T> {

  private static final Absent INSTANCE = new Absent();

  private Absent() {
  }

  @SuppressWarnings("unchecked")
  public static <T> Absent<T> instance() {
    return INSTANCE;
  }

  @Override
  public void ifPresent(Consumer<? super T> consumer) {
    // DO NOTHING
  }
}