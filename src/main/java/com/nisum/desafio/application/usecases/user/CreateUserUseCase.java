package com.nisum.desafio.application.usecases.user;

import com.nisum.desafio.domain.exceptions.EmailExistException;
import com.nisum.desafio.domain.models.User;
import com.nisum.desafio.domain.ports.in.usecases.parameter.IValidatePasswordUseCase;
import com.nisum.desafio.domain.ports.in.usecases.phone.ICreatePhoneUseCase;
import com.nisum.desafio.domain.ports.in.usecases.user.ICreateUserUseCase;
import com.nisum.desafio.domain.ports.in.usecases.user.ISecurityPasswordUseCase;
import com.nisum.desafio.domain.ports.out.repositories.IUserRepository;
import com.nisum.desafio.domain.utils.IGenerateTokenUseCase;
import com.nisum.desafio.shared.annotations.UseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;


@UseCase
@RequiredArgsConstructor
@Slf4j
public class CreateUserUseCase implements ICreateUserUseCase {
    private final IUserRepository repository;
    private final ICreatePhoneUseCase createPhoneUseCase;
    private final ISecurityPasswordUseCase securityPasswordUseCase;
    private final IValidatePasswordUseCase validatePasswordUseCase;
    private final IGenerateTokenUseCase generateTokenUseCase;

    @Transactional
    @Override
    public User execute(User user) {
        log.info("Creating user: {}", user);
        validatePasswordUseCase.execute(user.getPassword());
        User emailExist = repository.findByEmail(user.getEmail());
        if (emailExist!=null) {
            log.warn("User with email {} already exists", user.getEmail());
            throw new EmailExistException(user.getEmail());
        }
        user.setCreatedAt(LocalDateTime.now());
        user.setLastLogin(LocalDateTime.now());
        user.setActive(true);
        user.setPassword(securityPasswordUseCase.execute(user.getPassword()));
        user.setToken(generateTokenUseCase.execute(user));
        var userPersisted = repository.save(user);
        persistPhone(userPersisted);
        return userPersisted;
    }

    private void persistPhone(User user){
        user.getPhones().forEach(phone -> {
            phone.setUserId(user.getId());
            createPhoneUseCase.execute(phone);
        });
    }

}
