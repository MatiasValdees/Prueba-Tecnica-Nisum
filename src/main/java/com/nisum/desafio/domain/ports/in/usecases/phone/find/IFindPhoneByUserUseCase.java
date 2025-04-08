package com.nisum.desafio.domain.ports.in.usecases.phone.find;

import com.nisum.desafio.domain.models.phone.Phone;

import java.util.List;

public interface IFindPhoneByUserUseCase {
    List<Phone> execute(String userId);
}
