package com.nisum.desafio.infrastructure.adapter.out.repositories;

import com.nisum.desafio.domain.ports.out.repositories.IPasswordSecurityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class PasswordSecurityRepository implements IPasswordSecurityRepository {
    private final PasswordEncoder passwordEncoder;

    @Override
    public String encrypt(String password) {
        log.info("Encrypting password from passwordEncoder");
        return passwordEncoder.encode(password);
    }
}
