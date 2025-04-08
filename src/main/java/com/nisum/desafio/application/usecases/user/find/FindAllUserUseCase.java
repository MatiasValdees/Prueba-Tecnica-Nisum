package com.nisum.desafio.application.usecases.user.find;

import com.nisum.desafio.domain.models.User;
import com.nisum.desafio.domain.ports.in.usecases.user.find.IFindAllUserUseCase;
import com.nisum.desafio.domain.ports.out.repositories.IUserRepository;
import com.nisum.desafio.shared.annotations.UseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@UseCase
@RequiredArgsConstructor
@Slf4j
public class FindAllUserUseCase implements IFindAllUserUseCase {
    private final IUserRepository repository;

    @Override
    public List<User> execute() {
        log.info("Finding all users");
        var users = repository.findAll();
        log.info("users found: {}", users.size());
        return users;
    }
}
