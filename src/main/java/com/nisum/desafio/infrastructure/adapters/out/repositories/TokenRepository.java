package com.nisum.desafio.infrastructure.adapters.out.repositories;

import com.nisum.desafio.domain.models.User;
import com.nisum.desafio.domain.utils.IGenerateTokenUseCase;
import com.nisum.desafio.infrastructure.security.filters.utils.JwtProperties;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Date;
@Repository
@Slf4j
public class TokenRepository implements IGenerateTokenUseCase {

    @Override
    public String execute(User data) {
        log.info("Generating token for user: {}", data);
        return Jwts.builder()
                .signWith(JwtProperties.JWT_KEY)
                .header().type("JWT").and()
                .subject(data.getEmail())
                .claim("isActive", data.isActive())
                .claim("id", data.getId())
                .claim("name", data.getName())
                .claim("isActive", data.isActive())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+3600000*8))
                .compact();
    }
}
