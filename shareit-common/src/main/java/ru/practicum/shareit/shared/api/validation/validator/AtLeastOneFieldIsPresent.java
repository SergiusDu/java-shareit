package ru.practicum.shareit.shared.api.validation.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AtLeastOneFieldIsPresentValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AtLeastOneFieldIsPresent {
  String message() default "At least one field must be provided for the update";

  Class[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
