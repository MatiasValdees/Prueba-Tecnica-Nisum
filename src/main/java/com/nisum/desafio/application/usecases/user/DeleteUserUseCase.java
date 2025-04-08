package com.nisum.desafio.application.usecases.user;

import com.nisum.desafio.domain.ports.in.usecases.user.IDeleteUserUseCase;
import com.nisum.desafio.domain.ports.in.usecases.user.find.IFindUserByIdUseCase;
import com.nisum.desafio.domain.ports.out.repositories.IUserRepository;
import com.nisum.desafio.shared.annotations.UseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@UseCase
@RequiredArgsConstructor
@Slf4j
public class DeleteUserUseCase implements IDeleteUserUseCase {
    private final IUserRepository repository;
    private final IFindUserByIdUseCase findUserByIdUseCase;

    @Override
    public void execute(String id) {
        log.info("Deleting user with id: {}", id);
        findUserByIdUseCase.execute(id);
        repository.deleteById(id);
        log.info("User with id: {} deleted successfully", id);
    }
}
