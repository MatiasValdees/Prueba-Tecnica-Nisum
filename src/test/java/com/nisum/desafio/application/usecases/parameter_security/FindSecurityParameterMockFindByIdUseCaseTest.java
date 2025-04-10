package com.nisum.desafio.application.usecases.parameter_security;

import com.nisum.desafio.domain.exceptions.EntityNotFoundException;
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
class FindSecurityParameterMockFindByIdUseCaseTest {
    @Mock
    private ISecurityParameterRepository repository;
    @InjectMocks
    private FindSecurityParameterFindByIdUseCase findSecurityParameterFindByIdUseCase;

    @Test
    @DisplayName("SecurityParameter encontrado")
    void execute() {
        when(repository.findById(1L)).thenReturn(SecurityParameterMock.securityParameter);
        var parameter = findSecurityParameterFindByIdUseCase.execute(1L);
        assertNotNull(parameter,"Security Parameter no debe ser null");
    }

    @Test
    @DisplayName("SecurityParameter no encontrado")
    void executeNotFound() {
        when(repository.findById(2L)).thenReturn(null);
        assertThrows(EntityNotFoundException.class, () -> {
            findSecurityParameterFindByIdUseCase.execute(2L);
        }, "Security Parameter debe ser null");
    }

}