package com.nisum.desafio.infrastructure.db.jpa.repositories;

import com.nisum.desafio.infrastructure.db.jpa.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserJpaRepository extends CrudRepository<UserEntity, UUID> {
    Optional<UserEntity> findByEmail(String email);
}
