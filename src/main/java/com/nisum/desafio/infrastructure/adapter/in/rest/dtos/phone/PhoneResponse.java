package com.nisum.desafio.infrastructure.adapter.in.rest.dtos.phone;

import com.nisum.desafio.domain.models.phone.Phone;

public record PhoneResponse(
        String number,
        String cityCode,
        String countryCode
) {
    public static PhoneResponse fromDomain(Phone domain){
        return new PhoneResponse(
                domain.getNumber(),
                domain.getCityCode().getCode(),
                domain.getCityCode().getCountryCode().getCode()
        );
    }
}
