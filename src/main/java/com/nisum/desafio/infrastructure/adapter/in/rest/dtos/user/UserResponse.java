package com.nisum.desafio.infrastructure.adapter.in.rest.dtos.user;

import com.nisum.desafio.domain.models.User;
import com.nisum.desafio.infrastructure.adapter.in.rest.dtos.phone.PhoneResponse;

import java.util.List;

public record UserResponse(
        String name,
        String email,
        String password,
        List<PhoneResponse> phones
) {

    public static UserResponse fromDomain(User user){
        return new UserResponse(
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getPhones().stream()
                        .map(PhoneResponse::fromDomain)
                        .toList()
        );
    }
}
