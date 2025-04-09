package com.nisum.desafio.infrastructure.adapter.out.repositories;

import com.nisum.desafio.domain.models.phone.Phone;
import com.nisum.desafio.domain.ports.out.repositories.IPhoneRepository;
import com.nisum.desafio.infrastructure.db.jpa.entities.PhoneEntity;
import com.nisum.desafio.infrastructure.db.jpa.repositories.PhoneJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@RequiredArgsConstructor
@Slf4j
public class PhoneRepository implements IPhoneRepository {
    private final PhoneJpaRepository jpaRepository;

    @Override
    public Phone save(Phone phone) {
        log.info("Saving phone: {} from Jpa", phone);
        return jpaRepository.save(PhoneEntity.fromDomain(phone))
                .toDomain();
    }

    @Override
    public Phone findById(Long id) {
        log.info("Finding phone by id: {} from Jpa", id);
        return jpaRepository.findById(id)
                .map(PhoneEntity::toDomain)
                .orElse(null);
    }

    @Override
    public Phone findByNumberAndCityCodeId(String number, Long cityCodeId) {
        log.info("Finding phone by number: {} and cityCodeId:{} from Jpa", number, cityCodeId);
        return jpaRepository.findByNumberAndCityCodeId(number, cityCodeId)
                .map(PhoneEntity::toDomain)
                .orElse(null);
    }

    @Override
    public List<Phone> findByUserId(String userId) {
        log.info("Finding phones by userId: {} from Jpa", userId);
        return jpaRepository.findByUserId(userId)
                .stream()
                .map(PhoneEntity::toDomain)
                .toList();
    }
}
