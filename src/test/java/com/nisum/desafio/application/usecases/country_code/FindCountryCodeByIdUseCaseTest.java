package com.nisum.desafio.application.usecases.country_code;

import com.nisum.desafio.domain.exceptions.EntityNotFoundException;
import com.nisum.desafio.domain.ports.out.repositories.ICountryCodeRepository;
import com.nisum.desafio.mocks.CountryCodeMock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindCountryCodeByIdUseCaseTest {
    @Mock
    private ICountryCodeRepository repository;
    @InjectMocks
    private FindCountryCodeByIdUseCase findCountryCodeByIdUseCase;

    @Test
    @DisplayName("CountryCode encontrado")
    void execute() {
        when(repository.findById(1L)).thenReturn(CountryCodeMock.countryCode);
        var countryCode = findCountryCodeByIdUseCase.execute(1L);
        assertNotNull(countryCode,"Country code no debe ser null");
    }

    @Test
    @DisplayName("CountryCode no encontrado")
    void executeNotFound() {
        when(repository.findById(2L)).thenReturn(null);
        assertThrows(EntityNotFoundException.class, () -> {
            findCountryCodeByIdUseCase.execute(2L);
        }, "Country code debe ser null");
    }

}