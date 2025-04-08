package com.nisum.desafio.domain.exceptions;

import com.nisum.desafio.domain.models.phone.Phone;

public class PhoneExistException extends RuntimeException {
    public PhoneExistException(Phone phone) {
        super(String.format("Phone with number: %s, city code: %s, and country code: %s already exists",
                phone.getNumber(),
                phone.getCityCode().getCode()
                ,phone.getCityCode().getCountryCode().getCode())
        );
    }
}
