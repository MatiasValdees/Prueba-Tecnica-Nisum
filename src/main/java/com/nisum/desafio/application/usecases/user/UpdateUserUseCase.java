package com.nisum.desafio.application.usecases.user;

import com.nisum.desafio.domain.exceptions.EmailExistException;
import com.nisum.desafio.domain.models.User;
import com.nisum.desafio.domain.ports.in.usecases.user.IUpdateUserUseCase;
import com.nisum.desafio.domain.ports.in.usecases.user.find.IFindUserByIdUseCase;
import com.nisum.desafio.domain.ports.out.repositories.IUserRepository;
import com.nisum.desafio.shared.annotations.UseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@UseCase
@RequiredArgsConstructor
@Slf4j
public class UpdateUserUseCase implements IUpdateUserUseCase {
    private  final IUserRepository repository;
    private final IFindUserByIdUseCase findUserByIdUseCase;

    @Override
    public User execute(User user) {
        log.info("Updating user id: {}, payload: {}", user.getId(),user);
        var userFound = findUserByIdUseCase.execute(user.getId());
        validateEmail(user);
        userFound.setEmail(user.getEmail());
        userFound.setName(user.getName());
        userFound.setPassword(user.getPassword());
        return repository.save(userFound);
    }

    private void validateEmail(User user) {
        log.info("Validating email: {}", user.getEmail());
        var existEmail= repository.findByEmail(user.getEmail());
        if(!existEmail.getId().equals(user.getId())){
            log.warn("Email already exists: {}", user.getEmail());
            throw new EmailExistException(user.getEmail());
        }
        log.info("Email is valid not exist or is the same user");

    }
}
