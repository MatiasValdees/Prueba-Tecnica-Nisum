package com.nisum.desafio.infrastructure.adapter.in.rest.dtos.user;

import com.nisum.desafio.domain.models.User;
import com.nisum.desafio.infrastructure.adapter.in.rest.dtos.phone.PhoneCreateRequest;

import java.util.List;

public record UserCreateRequest(
        String name,
        String email,
        String password,
        List<PhoneCreateRequest> phones
) {
    public User toDomain(){
        return User.builder()
                .name(name)
                .email(email)
                .password(password)
                .phones(phones.stream().map(PhoneCreateRequest::toDomain).toList())
                .build();
    }
}
