package com.nisum.desafio.infrastructure.db.jpa.entities;

import com.nisum.desafio.domain.models.phone.CountryCode;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "country_codes")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CountryCodeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    @Column(unique = true)
    private String code;
    @Column(name = "country_id")
    private Long countryId;


    public static CountryCodeEntity fromDomain(CountryCode domain){
        return CountryCodeEntity.builder()
                .id(domain.getId())
                .name(domain.getName())
                .code(domain.getCode())
                .countryId(domain.getCountryId())
                .build();
    }

    public CountryCode toDomain() {
        return CountryCode.builder()
                .id(id)
                .name(name)
                .code(code)
                .countryId(countryId)
                .build();
    }
}
