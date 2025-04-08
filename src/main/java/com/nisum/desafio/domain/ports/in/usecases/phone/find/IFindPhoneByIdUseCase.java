package com.nisum.desafio.domain.ports.in.usecases.phone.find;

import com.nisum.desafio.domain.models.phone.Phone;

public interface IFindPhoneByIdUseCase {
    Phone execute(Long id);
}
