package com.nisum.desafio.application.usecases.phone;

import com.nisum.desafio.domain.exceptions.PhoneExistException;
import com.nisum.desafio.domain.models.phone.CityCode;
import com.nisum.desafio.domain.models.phone.Phone;
import com.nisum.desafio.domain.ports.in.usecases.phone.IUpdatePhoneUseCase;
import com.nisum.desafio.domain.ports.in.usecases.phone.find.IFindPhoneByIdUseCase;
import com.nisum.desafio.domain.ports.in.usecases.city_code.IFindCityCodeUseCase;
import com.nisum.desafio.domain.ports.out.repositories.IPhoneRepository;
import com.nisum.desafio.shared.annotations.UseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@UseCase
@RequiredArgsConstructor
@Slf4j
public class UpdatePhoneUseCase implements IUpdatePhoneUseCase {
    private final IPhoneRepository phoneRepository;
    private final IFindPhoneByIdUseCase findPhoneByIdUseCase;
    private final IFindCityCodeUseCase findCityCodeUseCase;

    @Override
    public Phone execute(Phone phone) {
        log.info("Updating phone with id: {}, payload: {}", phone.getId(),phone);
        Phone existById = findPhoneByIdUseCase.execute(phone.getId());
        CityCode cityCode = findCityCodeUseCase.execute(phone.getCityCode().getId());
        validatePhone(phone);
        existById.setNumber(phone.getNumber());
        existById.setCityCode(cityCode);
        return phoneRepository.save(existById);
    }

    private void validatePhone(Phone phone) {
        log.info("Validating phone");
        Phone existByPhone = phoneRepository.findByPhone(phone);
        if(!phone.getId().equals(existByPhone.getId())){
            log.warn("Phone already exists");
            throw new PhoneExistException(phone);
        }

    }
}
