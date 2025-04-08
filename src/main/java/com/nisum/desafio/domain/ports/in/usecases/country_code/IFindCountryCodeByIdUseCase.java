package com.nisum.desafio.domain.ports.in.usecases.country_code;

import com.nisum.desafio.domain.models.phone.CountryCode;

public interface IFindCountryCodeByIdUseCase {
    CountryCode execute(Long id);
}
