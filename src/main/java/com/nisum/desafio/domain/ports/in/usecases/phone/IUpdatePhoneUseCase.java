package com.nisum.desafio.domain.ports.in.usecases.phone;

import com.nisum.desafio.domain.models.phone.Phone;

public interface IUpdatePhoneUseCase {
    Phone execute(Phone phone);
}
