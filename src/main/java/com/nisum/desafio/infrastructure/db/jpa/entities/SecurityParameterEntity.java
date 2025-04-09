package com.nisum.desafio.infrastructure.db.jpa.entities;

import com.nisum.desafio.domain.models.SecurityParameter;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "security_parameters")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SecurityParameterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "min_length")
    private int minLength;
    @Column(name = "max_length")
    private int maxLength;
    @Column(name = "upper_case")
    private boolean upperCase;
    @Column(name = "lower_case")
    private boolean lowerCase;
    @Column(name = "special_character")
    private boolean specialCharacter;
    @Column(name = "number")
    private boolean number;

    public SecurityParameter toDomain(){
        return SecurityParameter
                .builder()
                .id(this.id)
                .minLength(this.minLength)
                .maxLength(this.maxLength)
                .upperCase(this.upperCase)
                .lowerCase(this.lowerCase)
                .specialCharacter(this.specialCharacter)
                .number(this.number)
                .build();
    }
    public static SecurityParameterEntity fromDomain(SecurityParameter securityParameter){
        return SecurityParameterEntity
                .builder()
                .id(securityParameter.getId())
                .minLength(securityParameter.getMinLength())
                .maxLength(securityParameter.getMaxLength())
                .upperCase(securityParameter.isUpperCase())
                .lowerCase(securityParameter.isLowerCase())
                .specialCharacter(securityParameter.isSpecialCharacter())
                .number(securityParameter.isNumber())
                .build();
    }
}
