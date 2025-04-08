package com.nisum.desafio.domain.ports.in.usecases.city_code;

import com.nisum.desafio.domain.models.phone.CityCode;

public interface IFindCityCodeUseCase {
    CityCode execute (Long id);
}
