package com.nisum.desafio.infrastructure.adapters.in.rest.dtos.user;

import com.nisum.desafio.domain.models.User;
import com.nisum.desafio.infrastructure.adapters.in.rest.dtos.phone.PhoneCreateRequest;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record UserCreateRequest(
        @NotBlank String name,
        @NotBlank @Email String email,
        @NotBlank String password,
        List<PhoneCreateRequest> phones
) {
    public User toDomain(){
        return User.builder()
                .name(name)
                .email(email)
                .password(password)
                .phones(phones!=null?phones.stream().map(PhoneCreateRequest::toDomain).toList():null)
                .build();
    }
}
