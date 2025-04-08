package com.nisum.desafio.infrastructure.db.jpa.entities;

import com.nisum.desafio.domain.models.User;
import com.nisum.desafio.domain.models.phone.Phone;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "users")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    private String id;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    @ManyToMany
    @JoinTable(
            name = "users_phones",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="phone_id"),
            uniqueConstraints = { @UniqueConstraint(columnNames = {"user_id","phone_id"})}
    )
    private List<PhoneEntity> phones;

    public static UserEntity fromDomain(User domain){
        return UserEntity.builder()
                .id(domain.getId())
                .name(domain.getName())
                .email(domain.getEmail())
                .password(domain.getPassword())
                .phones(domain.getPhones()
                        .stream()
                        .map(PhoneEntity::fromDomain)
                        .toList()
                )
                .build();
    }

    public User toDomain(){
        return User.builder()
                .id(this.id)
                .name(this.name)
                .email(this.email)
                .password(this.password)
                .phones(this.phones
                        .stream()
                        .map(PhoneEntity::toDomain)
                        .toList()
                )
                .build();
    }

}
