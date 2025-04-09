package com.nisum.desafio.infrastructure.adapter.out.repositories;

import com.nisum.desafio.domain.models.SecurityParameter;
import com.nisum.desafio.domain.ports.out.repositories.ISecurityParameterRepository;
import com.nisum.desafio.infrastructure.db.jpa.entities.SecurityParameterEntity;
import com.nisum.desafio.infrastructure.db.jpa.repositories.SecurityParameterJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class SecurityParameterRepository implements ISecurityParameterRepository {
    private final SecurityParameterJpaRepository jpaRepository;

    @Override
    public SecurityParameter save(SecurityParameter securityParameter) {
        log.info("Saving security parameter from Jpa");
        return jpaRepository.save(SecurityParameterEntity.fromDomain(securityParameter)).toDomain();
    }

    @Override
    public SecurityParameter findById(Long id) {
        log.info("Finding security parameter by id:{} from Jpa",id);
        return jpaRepository.findById(id)
                .map(SecurityParameterEntity::toDomain)
                .orElse(null);
    }
}
