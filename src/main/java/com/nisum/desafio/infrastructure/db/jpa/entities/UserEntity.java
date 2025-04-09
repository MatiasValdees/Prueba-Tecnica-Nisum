package com.nisum.desafio.infrastructure.db.jpa.entities;

import com.nisum.desafio.domain.models.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Table(name = "users")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserEntity {
    @Id
    @GeneratedValue
    @JdbcTypeCode(SqlTypes.UUID)
    private UUID id;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;
    @Column(name = "last_login")
    private LocalDateTime lastLogin;
    private Boolean active;
    @OneToMany(mappedBy = "user", cascade = CascadeType.DETACH, orphanRemoval = true)
    private List<PhoneEntity> phones;


    public static UserEntity fromDomain(User domain){
        return UserEntity.builder()
                .id(domain.getId()!=null?UUID.fromString(domain.getId()):null)
                .name(domain.getName())
                .email(domain.getEmail())
                .password(domain.getPassword())
                .createdAt(domain.getCreatedAt())
                .modifiedAt(domain.getModifiedAt())
                .lastLogin(domain.getLastLogin())
                .active(domain.isActive())
                .phones(domain.getPhones()!=null?
                        domain.getPhones()
                                .stream()
                                .map(PhoneEntity::fromDomain)
                                .toList()
                        :null
                )
                .build();
    }

    public User toDomain(){
        return User.builder()
                .id(this.id!=null?this.id.toString():null)
                .name(this.name)
                .email(this.email)
                .password(this.password)
                .createdAt(this.createdAt)
                .modifiedAt(this.modifiedAt)
                .lastLogin(this.lastLogin)
                .isActive(this.active)
                .phones(this.phones!=null?
                        this.phones
                                .stream()
                                .map(PhoneEntity::toDomain)
                                .toList()
                        :null
                )
                .build();
    }
}
