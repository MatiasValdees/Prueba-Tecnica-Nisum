package com.nisum.desafio.application.usecases.user.find;

import com.nisum.desafio.domain.exceptions.EntityNotFoundException;
import com.nisum.desafio.domain.models.User;
import com.nisum.desafio.domain.ports.in.usecases.user.find.IFindUserByIdUseCase;
import com.nisum.desafio.domain.ports.out.repositories.IUserRepository;
import com.nisum.desafio.shared.annotations.UseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static com.nisum.desafio.domain.models.constants.NisumConstant.USER_CONSTANT;


/**
 * Caso de uso para la validacion de un usuario por id.
 * Usado por caso de uso ***ACTUALIZAR USUARIO***.
 * Usado por caso de uso ***ELIMINAR USUARIO***.
 */
@UseCase
@RequiredArgsConstructor
@Slf4j
public class FindUserByIdUseCase implements IFindUserByIdUseCase {
    private final IUserRepository repository;

    @Override
    public User execute(String id) {
        log.info("Finding user by id: {}", id);
        var user = repository.findById(id);
        if (user==null) {
            log.warn("User not found with id: {}", id);
            throw new EntityNotFoundException(USER_CONSTANT,"id", id);
        }
        log.info("User found: {}", user);
        return user;
    }
}
