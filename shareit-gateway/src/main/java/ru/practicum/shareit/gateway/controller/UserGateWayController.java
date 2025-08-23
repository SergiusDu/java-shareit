package ru.practicum.shareit.gateway.controller;


import ru.practicum.shareit.gateway.dto.user.CreateUserDto;
import ru.practicum.shareit.gateway.dto.user.UpdateUserDto;
import ru.practicum.shareit.gateway.dto.user.UserResponse;
import ru.practicum.shareit.gateway.mapper.user.UserWebInMapper;
import ru.practicum.shareit.gateway.mapper.user.UserWebOutMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.practicum.shareit.user.application.port.in.UserManagementUseCase;

import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/users")
@RequiredArgsConstructor
public class UserGateWayController {
  private final UserWebInMapper userWebInMapper;
  private final UserWebOutMapper userWebOutMapper;
  private final UserManagementUseCase userManagementUseCase;

  @GetMapping("/{id}")
  public UserResponse getUser(@PathVariable long id) {
    return userWebOutMapper.toUserResponse(userManagementUseCase.findUserById(id)
                                                                .orElseThrow(() -> new NoSuchElementException(
                                                                    "User not found with id: " + id)));
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public UserResponse createUser(@Valid @RequestBody CreateUserDto createUserDto) {
    return userWebOutMapper.toUserResponse(userManagementUseCase.createUser(userWebInMapper.toCreateUserCommand(
        createUserDto)));
  }

  @PatchMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public UserResponse updateUser(@Valid @RequestBody UpdateUserDto updateUserDto, @PathVariable Long id) {
    return userWebOutMapper.toUserResponse(userManagementUseCase.updateUser(userWebInMapper.toUpdateUserCommand(
        updateUserDto,
        id)));
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteUser(@PathVariable long id) {
    userManagementUseCase.deleteUser(id);
  }
}
