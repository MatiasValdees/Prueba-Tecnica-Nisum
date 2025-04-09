package com.nisum.desafio.infrastructure.security.rest.dtos;

public record AuthResponse(
        String token,
        String username,
        boolean isactive
) {
}
