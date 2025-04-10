package com.nisum.desafio.mocks;

import com.nisum.desafio.domain.models.phone.CityCode;

public class CityCodeMock {
    public static CityCode cityCode1= CityCode
                                        .builder()
                                        .id(1L)
                                        .countryCode(CountryCodeMock.countryCode)
                                        .build();
}
