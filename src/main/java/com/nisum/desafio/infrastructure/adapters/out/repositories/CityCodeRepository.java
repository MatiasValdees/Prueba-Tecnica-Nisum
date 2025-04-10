package com.nisum.desafio.infrastructure.adapters.out.repositories;

import com.nisum.desafio.domain.models.phone.CityCode;
import com.nisum.desafio.domain.ports.out.repositories.ICityCodeRepository;
import com.nisum.desafio.infrastructure.db.jpa.entities.CityCodeEntity;
import com.nisum.desafio.infrastructure.db.jpa.repositories.CityCodeJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class CityCodeRepository implements ICityCodeRepository {
    private final CityCodeJpaRepository jpaRepository;

    @Override
    public CityCode findById(Long id) {
        log.info("Finding city code by id: {} from Jpa", id);
        return jpaRepository.findById(id)
                .map(CityCodeEntity::toDomain)
                .orElse(null);
    }
}
