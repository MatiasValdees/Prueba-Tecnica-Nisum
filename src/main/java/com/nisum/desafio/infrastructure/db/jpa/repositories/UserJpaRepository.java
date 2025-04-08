package com.nisum.desafio.infrastructure.db.jpa.repositories;

import com.nisum.desafio.infrastructure.db.jpa.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserJpaRepository extends CrudRepository<UserEntity,String> {
    Optional<UserEntity> findByEmail(String email);
}
