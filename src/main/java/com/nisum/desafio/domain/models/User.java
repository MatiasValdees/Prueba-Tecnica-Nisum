package com.nisum.desafio.domain.models;

import com.nisum.desafio.domain.models.phone.Phone;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class User {
    private String id;
    private String name;
    private String email;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private LocalDateTime lastLogin;
    private boolean isActive;
    private List<Phone> phones;
}
