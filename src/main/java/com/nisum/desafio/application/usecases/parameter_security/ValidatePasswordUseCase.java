package com.nisum.desafio.application.usecases.parameter_security;

import com.nisum.desafio.domain.exceptions.PasswordSecurityException;
import com.nisum.desafio.domain.ports.in.usecases.parameter.IFindSecurityParameterFindByIdUseCase;
import com.nisum.desafio.domain.ports.in.usecases.parameter.IValidatePasswordUseCase;
import com.nisum.desafio.shared.annotations.UseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@UseCase
@RequiredArgsConstructor
@Slf4j
public class ValidatePasswordUseCase implements IValidatePasswordUseCase {
    private final IFindSecurityParameterFindByIdUseCase parameterFindByIdUseCase;

    @Override
    public void execute(String password) {
        var security=parameterFindByIdUseCase.execute(1L);
        if (password.length() < security.getMinLength()) {
            throw new PasswordSecurityException("Password must be at least " + security.getMinLength() + " characters long.");
        }

        if (password.length() > security.getMaxLength()) {
            throw new PasswordSecurityException("Password must not exceed " + security.getMaxLength() + " characters.");
        }

        if (security.isUpperCase() && !password.matches(".*[A-Z].*")) {
            throw new PasswordSecurityException("Password must contain at least one uppercase letter.");
        }

        if (security.isLowerCase() && !password.matches(".*[a-z].*")) {
            throw new PasswordSecurityException("Password must contain at least one lowercase letter.");
        }

        if (security.isNumber() && !password.matches(".*\\d.*")) {
            throw new PasswordSecurityException("Password must contain at least one number.");
        }

        if (security.isSpecialCharacter() && !password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"|,.<>/?].*")) {
            throw new PasswordSecurityException("Password must contain at least one special character.");
        }

    }


}
