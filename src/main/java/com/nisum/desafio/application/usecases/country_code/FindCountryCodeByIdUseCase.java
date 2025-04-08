package com.nisum.desafio.application.usecases.country_code;

import com.nisum.desafio.domain.exceptions.EntityNotFoundException;
import com.nisum.desafio.domain.models.phone.CountryCode;
import com.nisum.desafio.domain.ports.in.usecases.country_code.IFindCountryCodeByIdUseCase;
import com.nisum.desafio.domain.ports.out.repositories.ICountryCodeRepository;
import com.nisum.desafio.shared.annotations.UseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static com.nisum.desafio.domain.models.constants.NisumConstant.COUNTRY_CODE_CONSTANT;

@UseCase
@RequiredArgsConstructor
@Slf4j
public class FindCountryCodeByIdUseCase implements IFindCountryCodeByIdUseCase {
    private final ICountryCodeRepository repository;

    @Override
    public CountryCode execute(Long id) {
        log.info("Finding country code by id: {}", id);
        CountryCode countryCode = repository.findById(id);
        if (countryCode==null){
            log.warn("Country code not found for id: {}", id);
            throw new EntityNotFoundException(COUNTRY_CODE_CONSTANT,"id", id.toString());
        }
        log.info("Found country code: {}", countryCode);
        return countryCode;
    }
}
