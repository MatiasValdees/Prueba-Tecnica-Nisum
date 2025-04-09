package com.nisum.desafio.application.usecases.user;

import com.nisum.desafio.domain.models.User;
import com.nisum.desafio.domain.ports.in.usecases.user.IUpdateLastLoginUseCase;
import com.nisum.desafio.domain.ports.out.repositories.IUserRepository;
import com.nisum.desafio.shared.annotations.UseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@UseCase
@RequiredArgsConstructor
@Slf4j
public class UpdateLastLoginUseCase implements IUpdateLastLoginUseCase {
    private final IUserRepository repository;

    @Override
    public void execute(User user) {
        log.info("Updating last login for user: {}", user.getEmail());
        user.setLastLogin(LocalDateTime.now());
        repository.save(user);
        log.info("Last login updated for user: {}", user.getEmail());
    }
}
