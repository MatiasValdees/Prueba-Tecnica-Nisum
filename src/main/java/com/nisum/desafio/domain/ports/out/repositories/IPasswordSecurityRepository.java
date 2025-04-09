package com.nisum.desafio.domain.ports.out.repositories;

public interface IPasswordSecurityRepository {
    String encrypt(String password);
}
