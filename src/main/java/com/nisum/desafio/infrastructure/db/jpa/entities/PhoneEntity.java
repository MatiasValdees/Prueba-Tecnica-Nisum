package com.nisum.desafio.infrastructure.db.jpa.entities;

import com.nisum.desafio.domain.models.phone.Phone;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table( name = "phones",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = { "number","city_code_id"})
        })
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PhoneEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String number;
    @ManyToOne
    @JoinColumn(name = "city_code_id",nullable = false)
    private CityCodeEntity cityCode;
    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private UserEntity user;

    public static PhoneEntity fromDomain(Phone phone) {
        return PhoneEntity.builder()
                .id(phone.getId())
                .number(phone.getNumber())
                .cityCode(phone.getCityCode()!=null?CityCodeEntity.fromDomain(phone.getCityCode()):null)
                .user(phone.getUserId()!=null?UserEntity.builder().id(UUID.fromString(phone.getUserId())).build():null)
                .build();
    }

    public Phone toDomain() {
        return Phone.builder()
                .id(this.id)
                .number(this.number)
                .cityCode(this.cityCode!= null ? this.cityCode.toDomain() : null)
                .userId(this.user!=null ? this.user.getId().toString() : null)
                .build();
    }
}
