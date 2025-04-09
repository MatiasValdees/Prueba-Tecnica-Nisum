package com.nisum.desafio.infrastructure.adapter.in.rest.dtos.phone;

import com.nisum.desafio.domain.models.phone.CityCode;
import com.nisum.desafio.domain.models.phone.Phone;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PhoneUpdateRequest(
        Long id,
        @NotBlank String number,
        @NotNull @Min(1) Long cityCodeId
) {
    public Phone toDomain() {
        return Phone.builder()
                .id(this.id)
                .number(this.number)
                .cityCode(CityCode.builder().id(this.cityCodeId).build())
                .build();
    }
}
