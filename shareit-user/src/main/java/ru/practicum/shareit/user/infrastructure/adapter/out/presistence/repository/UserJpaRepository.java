package ru.practicum.shareit.user.infrastructure.adapter.out.presistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.practicum.shareit.user.infrastructure.adapter.out.presistence.model.UserEntity;


public interface UserJpaRepository
    extends JpaRepository<UserEntity, Long> {
}
