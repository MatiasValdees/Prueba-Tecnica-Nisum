package com.nisum.desafio.domain.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SecurityParameter {
    private Long id;
    private int minLength;
    private int maxLength;
    private boolean upperCase;
    private boolean lowerCase;
    private boolean specialCharacter;
    private boolean number;
}
