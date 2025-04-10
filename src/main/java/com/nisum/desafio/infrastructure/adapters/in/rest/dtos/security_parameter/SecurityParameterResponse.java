package com.nisum.desafio.infrastructure.adapters.in.rest.dtos.security_parameter;

import com.nisum.desafio.domain.models.SecurityParameter;

public record SecurityParameterResponse(
        Long id,
        int minLength,
        int maxLength,
        boolean upperCase,
        boolean lowerCase,
        boolean specialCharacter,
        boolean number
) {
    public static SecurityParameterResponse fromDomain(SecurityParameter securityParameter) {
        return new SecurityParameterResponse(
                securityParameter.getId(),
                securityParameter.getMinLength(),
                securityParameter.getMaxLength(),
                securityParameter.isUpperCase(),
                securityParameter.isLowerCase(),
                securityParameter.isSpecialCharacter(),
                securityParameter.isNumber()
        );
    }
}
