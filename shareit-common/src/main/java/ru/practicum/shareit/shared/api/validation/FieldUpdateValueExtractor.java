package ru.practicum.shareit.shared.api.validation;

import jakarta.validation.valueextraction.ExtractedValue;
import jakarta.validation.valueextraction.UnwrapByDefault;
import jakarta.validation.valueextraction.ValueExtractor;
import ru.practicum.shareit.shared.api.patch.FieldUpdate;
import ru.practicum.shareit.shared.api.patch.Present;

@UnwrapByDefault
public class FieldUpdateValueExtractor implements ValueExtractor<FieldUpdate<@ExtractedValue ?>> {
  @Override
  public void extractValues(FieldUpdate<?> originalValue, ValueReceiver receiver) {
    if (originalValue instanceof Present<?> present) {
      receiver.value(null, present.value());
    }
  }
}
