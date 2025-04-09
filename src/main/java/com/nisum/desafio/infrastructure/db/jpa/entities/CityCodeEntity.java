package com.nisum.desafio.infrastructure.db.jpa.entities;

import com.nisum.desafio.domain.models.phone.CityCode;
import jakarta.persistence.*;
import lombok.*;

@Table( name = "city_codes",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"id", "country_code_id"})
        })
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CityCodeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;
    @ManyToOne
    @JoinColumn(name = "country_code_id")
    private CountryCodeEntity countryCode;

    public static CityCodeEntity fromDomain(CityCode cityCode) {
        return CityCodeEntity.builder()
                .id(cityCode.getId())
                .name(cityCode.getName())
                .code(cityCode.getCode())
                .countryCode(cityCode.getCountryCode()!= null ? CountryCodeEntity.fromDomain(cityCode.getCountryCode()) : null)
                .build();
    }
    public CityCode toDomain() {
        return CityCode.builder()
                .id(this.id)
                .name(this.name)
                .code(this.code)
                .countryCode(this.countryCode!= null ? this.countryCode.toDomain() : null)
                .build();
    }
}
