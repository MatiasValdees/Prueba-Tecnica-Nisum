package com.nisum.desafio.domain.ports.in.usecases.user;

import com.nisum.desafio.domain.models.User;


public interface ICreateUserUseCase {
    User execute(User user);
}
