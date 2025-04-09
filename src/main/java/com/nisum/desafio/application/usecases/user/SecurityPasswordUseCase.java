package com.nisum.desafio.application.usecases.user;

import com.nisum.desafio.domain.ports.in.usecases.user.ISecurityPasswordUseCase;
import com.nisum.desafio.domain.ports.out.repositories.IPasswordSecurityRepository;
import com.nisum.desafio.shared.annotations.UseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@UseCase
@RequiredArgsConstructor
@Slf4j
public class SecurityPasswordUseCase implements ISecurityPasswordUseCase {
    private final IPasswordSecurityRepository repository;

    @Override
    public String execute(String password) {
        log.info("Encrypting password");
        return repository.encrypt(password);
    }
}
