package ru.practicum.shareit.shared.api.patch;

import java.util.function.Consumer;

public sealed interface FieldUpdate<T>
    permits Present, Absent {
  void ifPresent(Consumer<? super T> consumer);
}
