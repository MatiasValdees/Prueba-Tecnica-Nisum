package com.nisum.desafio.domain.ports.out.repositories;

import com.nisum.desafio.domain.models.User;

import java.util.List;

public interface IUserRepository {
    User save(User user);
    void deleteById(String id);
    User findById(String id);
    User findByEmail(String email);
    List<User> findAll();

}
