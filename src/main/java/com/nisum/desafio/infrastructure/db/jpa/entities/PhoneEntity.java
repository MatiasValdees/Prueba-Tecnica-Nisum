package com.nisum.desafio.infrastructure.db.jpa.entities;

import com.nisum.desafio.domain.models.phone.Phone;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "phones")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PhoneEntity {
    private Long id;
    private String number;
    @ManyToOne
    @JoinColumn(name = "city_code_id")
    private CityCodeEntity cityCode;

    public static PhoneEntity fromDomain(Phone phone) {
        return PhoneEntity.builder()
                .id(phone.getId())
                .number(phone.getNumber())
                .cityCode(CityCodeEntity.fromDomain(phone.getCityCode()))
                .build();
    }

    public Phone toDomain() {
        return Phone.builder()
                .id(this.id)
                .number(this.number)
                .cityCode(this.cityCode.toDomain())
                .build();
    }
}
