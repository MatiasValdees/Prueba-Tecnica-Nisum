package com.nisum.desafio.domain.ports.out.repositories;

import com.nisum.desafio.domain.models.phone.Phone;

import java.util.List;

public interface IPhoneRepository {
    Phone save(Phone phone);
    Phone findById(Long id);
    Phone findByNumberAndCityCodeId(String number, Long cityCodeId);
    void deleteById(Long id);
    List<Phone> findByUserId(String userId);
}
