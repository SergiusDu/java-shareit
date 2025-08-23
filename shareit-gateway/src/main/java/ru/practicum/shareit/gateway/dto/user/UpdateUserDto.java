package ru.practicum.shareit.gateway.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import ru.practicum.shareit.shared.api.patch.FieldUpdate;
import ru.practicum.shareit.shared.api.validation.validator.AtLeastOneFieldIsPresent;

@AtLeastOneFieldIsPresent
public record UpdateUserDto(FieldUpdate<@NotBlank String> name,
                            FieldUpdate<@Email String> email) {
}
