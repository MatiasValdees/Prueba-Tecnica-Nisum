package com.nisum.desafio.domain.ports.out.repositories;

import com.nisum.desafio.domain.models.phone.CountryCode;

public interface ICountryCodeRepository {
    CountryCode findById(Long id);
}
