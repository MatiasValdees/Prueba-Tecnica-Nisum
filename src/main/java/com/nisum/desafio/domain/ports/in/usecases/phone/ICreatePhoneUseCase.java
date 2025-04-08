package com.nisum.desafio.domain.ports.in.usecases.phone;

import com.nisum.desafio.domain.models.phone.Phone;

public interface ICreatePhoneUseCase {
    Phone execute(Phone phone);
}
