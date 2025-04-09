package com.nisum.desafio.domain.ports.out.repositories;

import com.nisum.desafio.domain.models.SecurityParameter;

public interface ISecurityParameterRepository {
    SecurityParameter save(SecurityParameter id);
    SecurityParameter findById(Long id);
}
