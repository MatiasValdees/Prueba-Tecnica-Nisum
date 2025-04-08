package com.nisum.desafio.application.usecases.user.find;

import com.nisum.desafio.domain.exceptions.EntityNotFoundException;
import com.nisum.desafio.domain.models.User;
import com.nisum.desafio.domain.ports.in.usecases.user.find.IFindUserByEmailUseCase;
import com.nisum.desafio.domain.ports.out.repositories.IUserRepository;
import com.nisum.desafio.shared.annotations.UseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static com.nisum.desafio.domain.models.constants.NisumConstant.USER_CONSTANT;


/**
 * Caso de uso para la validacion de un usuario por email.
 * Usado por ***Login***.
 */
@UseCase
@RequiredArgsConstructor
@Slf4j
public class FindUserByEmailUseCase implements IFindUserByEmailUseCase {
    private final IUserRepository repository;

    @Override
    public User execute(String email) {
        log.info("Finding user by email: {}", email);
        var user = repository.findByEmail(email);
        if(user==null){
            log.warn("User not found with email: {}", email);
            throw new EntityNotFoundException(USER_CONSTANT,"email", email);
        }
        log.info("User found: {}", user);
        return user;
    }
}
