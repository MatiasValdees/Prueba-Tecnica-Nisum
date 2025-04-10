package com.nisum.desafio.application.usecases.phone.find;

import com.nisum.desafio.domain.exceptions.EntityNotFoundException;
import com.nisum.desafio.domain.models.phone.Phone;
import com.nisum.desafio.domain.ports.out.repositories.IPhoneRepository;
import com.nisum.desafio.mocks.PhoneMock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindPhoneByIdUseCaseTest {
    @Mock
    private IPhoneRepository repository;
    @InjectMocks
    private FindPhoneByIdUseCase findPhoneByIdUseCase;
    @Test
    @DisplayName("Phone encontrado")
    void execute() {
        when(repository.findById(1L)).thenReturn(PhoneMock.phone1);
        Phone exist=findPhoneByIdUseCase.execute(1L);
        assertNotNull(exist,"Phone no debe ser null");
    }

    @Test
    @DisplayName("Phone no encontrado")
    void executeNotPhone() {
        when(repository.findById(1L)).thenReturn(null);
        assertThrows(EntityNotFoundException.class, () -> {
            findPhoneByIdUseCase.execute(1L);
        }, "Excepcion no lanzada");
    }
}