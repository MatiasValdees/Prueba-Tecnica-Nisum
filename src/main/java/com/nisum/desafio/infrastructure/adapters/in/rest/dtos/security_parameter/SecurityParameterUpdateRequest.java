package com.nisum.desafio.infrastructure.adapters.in.rest.dtos.security_parameter;

import com.nisum.desafio.domain.models.SecurityParameter;

public record SecurityParameterUpdateRequest(
        Long id,
        int minLength,
        int maxLength,
        boolean upperCase,
        boolean lowerCase,
        boolean specialCharacter,
        boolean number
) {
    public SecurityParameter toDomain() {
        return SecurityParameter.builder()
                .id(id)
                .minLength(minLength)
                .maxLength(maxLength)
                .upperCase(upperCase)
                .lowerCase(lowerCase)
                .specialCharacter(specialCharacter)
                .number(number)
                .build();
    }
}
