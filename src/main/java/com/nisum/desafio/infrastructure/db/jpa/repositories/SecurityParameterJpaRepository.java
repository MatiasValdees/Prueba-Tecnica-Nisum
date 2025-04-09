package com.nisum.desafio.infrastructure.db.jpa.repositories;

import com.nisum.desafio.infrastructure.db.jpa.entities.SecurityParameterEntity;
import org.springframework.data.repository.CrudRepository;

public interface SecurityParameterJpaRepository extends CrudRepository<SecurityParameterEntity,Long> {
}
