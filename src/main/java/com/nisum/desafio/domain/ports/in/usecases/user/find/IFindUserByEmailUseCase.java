package com.nisum.desafio.domain.ports.in.usecases.user.find;

import com.nisum.desafio.domain.models.User;


public interface IFindUserByEmailUseCase {
    User execute(String email);
}
