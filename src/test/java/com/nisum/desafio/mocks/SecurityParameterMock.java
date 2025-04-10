package com.nisum.desafio.mocks;


import com.nisum.desafio.domain.models.SecurityParameter;

public class SecurityParameterMock {
    public static SecurityParameter securityParameter = SecurityParameter.builder()
            .id(1L)
            .minLength(5)
            .maxLength(10)
            .upperCase(false)
            .lowerCase(false)
            .specialCharacter(false)
            .number(false)
            .build();
}
