package com.nisum.desafio.infrastructure.adapter.in.rest.dtos.user;

import com.nisum.desafio.domain.models.User;
import com.nisum.desafio.infrastructure.adapter.in.rest.dtos.phone.PhoneUpdateRequest;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record UserUpdateRequest(
        @NotBlank String id,
        String name,
        String email,
        String password,
        List<PhoneUpdateRequest> phones
) {
    public User toDomain(){
        return User.builder()
                .id(id)
                .name(name)
                .email(email)
                .password(password)
                .phones(phones.stream().map(PhoneUpdateRequest::toDomain).toList())
                .build();
    }
}
