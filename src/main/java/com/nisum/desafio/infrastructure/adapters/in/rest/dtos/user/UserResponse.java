package com.nisum.desafio.infrastructure.adapters.in.rest.dtos.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nisum.desafio.domain.models.User;
import com.nisum.desafio.infrastructure.adapters.in.rest.dtos.phone.PhoneResponse;

import java.time.LocalDateTime;
import java.util.List;

public record UserResponse(
        String id,
        String name,
        String email,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
        LocalDateTime created,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
        LocalDateTime modified,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
        LocalDateTime last_login,
        boolean isactive,
        String token,
        List<PhoneResponse> phones
) {

    public static UserResponse fromDomain(User user){
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getModifiedAt(),
                user.getLastLogin(),
                user.isActive(),
                user.getToken(),
                user.getPhones()!=null?
                    user.getPhones().stream()
                        .map(PhoneResponse::fromDomain)
                        .toList()
                    :
                    null
        );
    }
}
