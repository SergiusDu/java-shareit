package ru.practicum.shareit.user.application.command;

import ru.practicum.shareit.shared.api.patch.FieldUpdate;

public record UpdateUserCommand(long id,
                                FieldUpdate<String> name,
                                FieldUpdate<String> email) {
}
