package com.nisum.desafio.application.usecases.parameter_security;

import com.nisum.desafio.domain.models.SecurityParameter;
import com.nisum.desafio.domain.ports.in.usecases.parameter.IFindSecurityParameterFindByIdUseCase;
import com.nisum.desafio.domain.ports.out.repositories.ISecurityParameterRepository;
import com.nisum.desafio.mocks.SecurityParameterMock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdateSecurityParameterUseCaseTest {
    @Mock
    private IFindSecurityParameterFindByIdUseCase findSecurityParameterFindByIdUseCase;
    @Mock
    private ISecurityParameterRepository repository;
    @InjectMocks
    UpdateSecurityParameterUseCase updateSecurityParameterUseCase;
    @Test
    @DisplayName("Test Actualizar Parametro de Seguridad")
    void execute() {
        SecurityParameter toUpdate = SecurityParameter.builder()
                .id(1L)
                .minLength(8)
                .maxLength(16)
                .upperCase(true)
                .lowerCase(true)
                .specialCharacter(true)
                .number(true)
                .build();
        when(findSecurityParameterFindByIdUseCase.execute(1L)).thenReturn(SecurityParameterMock.securityParameter);
        when(repository.save(toUpdate)).thenReturn(SecurityParameterMock.securityParameter);

        var securityParameter = updateSecurityParameterUseCase.execute(SecurityParameterMock.securityParameter);
        assertAll(()->{
            assertEquals(toUpdate.getMinLength(), securityParameter.getMinLength(),"MinLength");
            assertEquals(toUpdate.getMaxLength(), securityParameter.getMaxLength(),"MaxLength");
            assertEquals(toUpdate.isUpperCase(), securityParameter.isUpperCase(),"UpperCase");
            assertEquals(toUpdate.isLowerCase(), securityParameter.isLowerCase(),"LowerCase");
            assertEquals(toUpdate.isSpecialCharacter(), securityParameter.isSpecialCharacter(),"SpecialCharacter");
            assertEquals(toUpdate.isNumber(), securityParameter.isNumber(),"Number");
        });
    }
}