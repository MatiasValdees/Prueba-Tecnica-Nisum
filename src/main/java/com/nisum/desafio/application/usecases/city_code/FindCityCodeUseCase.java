package com.nisum.desafio.application.usecases.city_code;

import com.nisum.desafio.domain.exceptions.EntityNotFoundException;
import com.nisum.desafio.domain.models.phone.CityCode;
import com.nisum.desafio.domain.ports.in.usecases.city_code.IFindCityCodeUseCase;
import com.nisum.desafio.domain.ports.out.repositories.ICityCodeRepository;
import com.nisum.desafio.shared.annotations.UseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static com.nisum.desafio.domain.models.constants.NisumConstant.CITY_CODE_CONSTANT;

/**
 * Caso de uso para encontrar un código de ciudad por su ID.
 * Usado por caso de uso ***CREAR TELEFONO***.
 * Usado por caso de uso ***ACTUALIZAR TELEFONO***.
 */
@UseCase
@RequiredArgsConstructor
@Slf4j
public class FindCityCodeUseCase implements IFindCityCodeUseCase {
    private final ICityCodeRepository repository;

    @Override
    public CityCode execute(Long id) {
        log.info("Finding city code with id: {}", id);
        CityCode cityCode = repository.findById(id);
        if (cityCode == null) {
            log.info("City code found: {}", cityCode);
            throw new EntityNotFoundException(CITY_CODE_CONSTANT,"id", id.toString());
        }
        log.info("City code found: {}", cityCode);
        return cityCode;
    }
}
