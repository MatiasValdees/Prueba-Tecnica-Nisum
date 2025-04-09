package com.nisum.desafio.domain.ports.in.usecases.parameter;

import com.nisum.desafio.domain.models.SecurityParameter;

public interface IFindSecurityParameterFindByIdUseCase {
    SecurityParameter execute(Long id);
}
