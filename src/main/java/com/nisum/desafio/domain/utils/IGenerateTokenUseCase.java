package com.nisum.desafio.domain.utils;

import com.nisum.desafio.domain.models.User;

public interface IGenerateTokenUseCase {
    String execute(User user);
}
