package com.nisum.desafio.domain.ports.out.repositories;

import com.nisum.desafio.domain.models.phone.CityCode;

public interface ICityCodeRepository {
    CityCode findById(Long id);
}
