package com.nisum.desafio.mocks;

import com.nisum.desafio.domain.models.phone.Phone;

import java.util.UUID;

public class PhoneMock {
    public static Phone phone1= Phone.builder()
            .id(1L)
            .cityCode(CityCodeMock.cityCode1)
            .number("999999999")
            .userId(UUID.randomUUID().toString())
            .build();
    public static Phone phone2= Phone.builder()
            .id(2L)
            .cityCode(CityCodeMock.cityCode1)
            .number("888888888")
            .userId(UUID.randomUUID().toString())
            .build();
}
