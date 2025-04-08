package com.nisum.desafio.infrastructure.adapter.out.repositories;

import com.nisum.desafio.domain.models.phone.CountryCode;
import com.nisum.desafio.domain.ports.out.repositories.ICountryCodeRepository;
import com.nisum.desafio.infrastructure.db.jpa.entities.CountryCodeEntity;
import com.nisum.desafio.infrastructure.db.jpa.repositories.CountryCodeJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class CountryCodeRepository implements ICountryCodeRepository {
    private final CountryCodeJpaRepository jpaRepository;

    @Override
    public CountryCode findById(Long id) {
        log.info("Finding country code by id: {} from Jpa", id);
        return jpaRepository.findById(id)
                .map(CountryCodeEntity::toDomain)
                .orElse(null);
    }
}
