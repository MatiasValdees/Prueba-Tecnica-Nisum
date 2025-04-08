package com.nisum.desafio.domain.ports.in.usecases.user.find;

import com.nisum.desafio.domain.models.User;

import java.util.List;

public interface IFindAllUserUseCase {
    List<User>execute();
}
