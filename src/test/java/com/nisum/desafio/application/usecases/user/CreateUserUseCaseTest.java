package com.nisum.desafio.application.usecases.user;

import com.nisum.desafio.domain.exceptions.EmailExistException;
import com.nisum.desafio.domain.models.User;
import com.nisum.desafio.domain.ports.in.usecases.parameter.IValidatePasswordUseCase;
import com.nisum.desafio.domain.ports.in.usecases.phone.ICreatePhoneUseCase;
import com.nisum.desafio.domain.ports.in.usecases.user.ISecurityPasswordUseCase;
import com.nisum.desafio.domain.ports.out.repositories.IUserRepository;
import com.nisum.desafio.domain.utils.IGenerateTokenUseCase;
import com.nisum.desafio.mocks.PhoneMock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateUserUseCaseTest {
    @Mock
    private IUserRepository repository;
    @Mock
    private ICreatePhoneUseCase createPhoneUseCase;
    @Mock
    private ISecurityPasswordUseCase securityPasswordUseCase;
    @Mock
    private IValidatePasswordUseCase validatePasswordUseCase;
    @Mock
    private IGenerateTokenUseCase generateTokenUseCase;
    @InjectMocks
    private CreateUserUseCase createUserUseCase;

    @Test
    @DisplayName("Test Creación Usuario exitosa")
    void execute() {
        String password = "Password";
        String passwordHash = "PasswordHash";
        User user = User.builder()
                .id(UUID.randomUUID().toString())
                .email("mvaldes@nisum.com")
                .name("Matias Valdes")
                .password(password)
                .phones(List.of(PhoneMock.phone1, PhoneMock.phone2))
                .build();

        doNothing().when(validatePasswordUseCase).execute(anyString());
        when(repository.findByEmail(anyString())).thenReturn(null);
        when(securityPasswordUseCase.execute(password)).thenReturn(passwordHash);
        when(generateTokenUseCase.execute(user)).thenReturn("token");
        when(repository.save(user)).thenReturn(user);
        when(createPhoneUseCase.execute(any())).thenReturn(any());
        createUserUseCase.execute(user);
        assertAll(() -> {
            assertNotNull(user.getId(), "Id no debe ser null");
            assertNotNull(user.getCreatedAt(), "CreatedAt no debe ser null");
            assertNotNull(user.getLastLogin(), "LastLogin no debe ser null");
            assertTrue(user.isActive(), "Usuario debe estar activo");
            assertEquals(passwordHash, user.getPassword(), "Password no coincide");
            assertEquals("token", user.getToken(), "Token no coincide");
            assertEquals(2, user.getPhones().size(), "Cantidad de telefonos no coincide");
        });
    }

    @Test
    @DisplayName("Test Correo existente")
    void executeEmailExist() {
        String password = "Password";
        User user = User.builder()
                .id(UUID.randomUUID().toString())
                .email("mvaldes@nisum.com")
                .name("Matias Valdes")
                .password(password)
                .phones(List.of(PhoneMock.phone1, PhoneMock.phone2))
                .build();

        doNothing().when(validatePasswordUseCase).execute(anyString());
        when(repository.findByEmail(anyString())).thenReturn(User.builder().build());
        assertThrows(EmailExistException.class, () -> {
            when(repository.findByEmail(user.getEmail())).thenReturn(user);
            createUserUseCase.execute(user);
        }, "El correo ya existe");

    }
}