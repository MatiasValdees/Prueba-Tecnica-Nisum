package com.nisum.desafio.application.usecases.phone;

import com.nisum.desafio.domain.exceptions.PhoneExistException;
import com.nisum.desafio.domain.models.phone.CityCode;
import com.nisum.desafio.domain.models.phone.Phone;
import com.nisum.desafio.domain.ports.in.usecases.phone.ICreatePhoneUseCase;
import com.nisum.desafio.domain.ports.in.usecases.city_code.IFindCityCodeUseCase;
import com.nisum.desafio.domain.ports.out.repositories.IPhoneRepository;
import com.nisum.desafio.shared.annotations.UseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@UseCase
@RequiredArgsConstructor
@Slf4j
public class CreatePhoneUseCase implements ICreatePhoneUseCase {
    private final IPhoneRepository repository;
    private final IFindCityCodeUseCase findCityCodeUseCase;

    @Override
    public Phone execute(Phone phone) {
        log.info("Creating phone: {}", phone);
        Phone phoneExist = repository.findByNumberAndCityCodeId(phone.getNumber(),phone.getCityCode().getId());
        if (phoneExist != null) {
            log.warn("Phone already exists: {}", phoneExist);
            throw new PhoneExistException(phoneExist);
        }
        CityCode cityCode = findCityCodeUseCase.execute(phone.getCityCode().getId());
        phone.setCityCode(cityCode);
        return repository.save(phone);
    }
}
