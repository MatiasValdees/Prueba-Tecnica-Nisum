package com.nisum.desafio.infrastructure.adapter.in.rest.dtos.phone;

import com.nisum.desafio.domain.models.phone.CityCode;
import com.nisum.desafio.domain.models.phone.Phone;

public record PhoneCreateRequest(
        String number,
        Long cityCodeId
) {
    public Phone toDomain() {
        return Phone.builder()
                .number(this.number)
                .cityCode(CityCode.builder().id(this.cityCodeId).build())
                .build();
    }
}
