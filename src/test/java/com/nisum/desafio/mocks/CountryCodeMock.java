package com.nisum.desafio.mocks;

import com.nisum.desafio.domain.models.phone.CountryCode;

public class CountryCodeMock {
    public static CountryCode countryCode=CountryCode.builder()
            .code("+57")
            .name("Colombia")
            .id(1L)
            .build();
}
