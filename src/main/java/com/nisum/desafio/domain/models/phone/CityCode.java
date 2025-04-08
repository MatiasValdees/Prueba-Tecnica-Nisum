package com.nisum.desafio.domain.models.phone;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CityCode {
    private Long id;
    private String name;
    private String code;
    private CountryCode countryCode;
}
