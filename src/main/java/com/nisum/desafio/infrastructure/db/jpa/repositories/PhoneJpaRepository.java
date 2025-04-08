package com.nisum.desafio.infrastructure.db.jpa.repositories;

import com.nisum.desafio.domain.models.phone.Phone;
import com.nisum.desafio.infrastructure.db.jpa.entities.PhoneEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PhoneJpaRepository extends CrudRepository<PhoneEntity,Long> {
    @Query( value = "SELECT * FROM phones p WHERE p.number = ?1 AND p.city_code_id = ?2 ",
            nativeQuery = true)
    Optional<PhoneEntity> findByPhone(Phone phone);

    @Query(value = "SELECT p.* FROM phones p INNER JOIN user_phones up ON p.id = up.phone_id WHERE up.user_id = ?1", nativeQuery = true)
    List<PhoneEntity> findByUserId(String userId);
}
