package com.nisum.desafio.domain.models.phone;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Phone {
    private Long id;
    private String number;
    private CityCode cityCode;
}
