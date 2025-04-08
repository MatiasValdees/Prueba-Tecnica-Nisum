package com.nisum.desafio.infrastructure.db.jpa.repositories;

import com.nisum.desafio.infrastructure.db.jpa.entities.CountryCodeEntity;
import org.springframework.data.repository.CrudRepository;

public interface CountryCodeJpaRepository extends CrudRepository<CountryCodeEntity,Long> {
}
