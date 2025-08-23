package ru.practicum.shareit.shared.api.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import ru.practicum.shareit.shared.api.patch.Present;

import java.lang.reflect.RecordComponent;
import java.util.Objects;

public class AtLeastOneFieldIsPresentValidator
    implements ConstraintValidator<AtLeastOneFieldIsPresent, Object> {
  @Override
  public boolean isValid(Object value, ConstraintValidatorContext context) {
    if (Objects.isNull(value))
      return true;

    Class<?> type = value.getClass();
    if (type.isRecord()) {
      for (RecordComponent rc : type.getRecordComponents()) {
        try {
          Object v = rc.getAccessor()
                       .invoke(value);
          if (v instanceof Present<?>)
            return true;
        } catch (Throwable ignored) {
        }
      }
      return false;
    }

    try {
      var fields = type.getDeclaredFields();
      for (var f : fields) {
        f.setAccessible(true);
        Object v = f.get(value);
        if (v instanceof Present<?>)
          return true;
      }
    } catch (IllegalAccessException e) {
      return false;
    }
    return false;
  }
}
