package com.nisum.desafio.application.usecases.city_code;

import com.nisum.desafio.domain.exceptions.EntityNotFoundException;
import com.nisum.desafio.domain.ports.out.repositories.ICityCodeRepository;
import com.nisum.desafio.mocks.CityCodeMock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindCityCodeUseCaseTest {

    @Mock
    private ICityCodeRepository repository;
    @InjectMocks
    private FindCityCodeUseCase findCityCodeUseCase;


    @Test
    @DisplayName("CityCode encontrado")
    void execute() {
        when(repository.findById(1L)).thenReturn(CityCodeMock.cityCode1);
        var cityCode = findCityCodeUseCase.execute(1L);
        assertNotNull(cityCode,"City code no debe ser null");
    }

    @Test
    @DisplayName("CityCode no encontrado")
    void executeNotFound() {
        when(repository.findById(2L)).thenReturn(null);
        assertThrows(EntityNotFoundException.class, () -> {
            findCityCodeUseCase.execute(2L);
        }, "City code debe ser null");
    }
}