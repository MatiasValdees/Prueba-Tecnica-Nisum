package com.nisum.desafio.infrastructure.db.jpa.repositories;

import com.nisum.desafio.infrastructure.db.jpa.entities.CityCodeEntity;
import org.springframework.data.repository.CrudRepository;

public interface CityCodeJpaRepository extends CrudRepository<CityCodeEntity,Long> {
}
