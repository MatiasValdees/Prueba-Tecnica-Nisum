package com.nisum.desafio.infrastructure.adapters.out.repositories;

import com.nisum.desafio.domain.models.User;
import com.nisum.desafio.domain.ports.out.repositories.IUserRepository;
import com.nisum.desafio.infrastructure.db.jpa.entities.UserEntity;
import com.nisum.desafio.infrastructure.db.jpa.repositories.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
@Slf4j
public class UserRepository implements IUserRepository {
    private final UserJpaRepository jpaRepository;

    @Override
    public User save(User user) {
        log.info("Saving user: {} from Jpa", user);
        return jpaRepository.save(UserEntity.fromDomain(user))
                .toDomain();
    }

    @Override
    public void deleteById(String id) {
        log.info("Deleting user with id: {} from Jpa", id);
        jpaRepository.deleteById(UUID.fromString(id));
    }

    @Override
    public User findById(String id) {
        log.info("Finding user with id: {} from Jpa", id);
        return jpaRepository.findById(UUID.fromString(id))
                .map(UserEntity::toDomain)
                .orElse(null);
    }

    @Override
    public User findByEmail(String email) {
        log.info("Finding user with email: {} from Jpa", email);
        return jpaRepository.findByEmail(email)
                .map(UserEntity::toDomain)
                .orElse(null);
    }

    @Override
    public List<User> findAll() {
        log.info("Finding all users from Jpa");
        return ((List<UserEntity>) jpaRepository.findAll())
                .stream()
                .map(UserEntity::toDomain)
                .toList();
    }
}
