package com.nisum.desafio.infrastructure.adapter.in.rest.impl;

import com.nisum.desafio.domain.ports.in.usecases.user.ICreateUserUseCase;
import com.nisum.desafio.domain.ports.in.usecases.user.IDeleteUserUseCase;
import com.nisum.desafio.domain.ports.in.usecases.user.IUpdateUserUseCase;
import com.nisum.desafio.domain.ports.in.usecases.user.find.IFindAllUserUseCase;
import com.nisum.desafio.domain.ports.in.usecases.user.find.IFindUserByIdUseCase;
import com.nisum.desafio.infrastructure.adapter.in.rest.IUserController;
import com.nisum.desafio.infrastructure.adapter.in.rest.dtos.WrapperResponse;
import com.nisum.desafio.infrastructure.adapter.in.rest.dtos.user.UserCreateRequest;
import com.nisum.desafio.infrastructure.adapter.in.rest.dtos.user.UserResponse;
import com.nisum.desafio.infrastructure.adapter.in.rest.dtos.user.UserUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController implements IUserController {
    private final ICreateUserUseCase createUserUseCase;
    private final IUpdateUserUseCase updateUserUseCase;
    private final IFindUserByIdUseCase findUserByIdUseCase;
    private final IDeleteUserUseCase deleteUserUseCase;
    private final IFindAllUserUseCase findAllUserUseCase;


    @GetMapping
    @Override
    public ResponseEntity<WrapperResponse<List<UserResponse>>> readAll() {
        List<UserResponse> list= findAllUserUseCase.execute().stream().map(UserResponse::fromDomain).toList();
        //Envolvendo a respuesta
        WrapperResponse<List<UserResponse>> response = WrapperResponse.<List<UserResponse>>builder()
                .status("OK")
                .timestamp(LocalDateTime.now().toString())
                .data(list)
                .build();
        return ResponseEntity
                .ok()
                .body(response);
    }
    @PostMapping
    @Override
    public ResponseEntity<WrapperResponse<UserResponse>> create(@RequestBody UserCreateRequest request) {
        UserResponse userResponse = UserResponse.fromDomain(createUserUseCase.execute(request.toDomain()));
        //Envolvendo a respuesta
        WrapperResponse<UserResponse> response = WrapperResponse.<UserResponse>builder()
                .status("OK")
                .timestamp(LocalDateTime.now().toString())
                .data(userResponse)
                .build();

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
    @PutMapping
    @Override
    public ResponseEntity<WrapperResponse<UserResponse>> update(@RequestBody UserUpdateRequest request) {
        UserResponse userResponse = UserResponse.fromDomain(updateUserUseCase.execute(request.toDomain()));
        //Envolvendo a respuesta
        WrapperResponse<UserResponse> response = WrapperResponse.<UserResponse>builder()
                .status("OK")
                .timestamp(LocalDateTime.now().toString())
                .data(userResponse)
                .build();

        return ResponseEntity
                .ok(response);
    }
    @GetMapping("findById/{id}")
    @Override
    public ResponseEntity<WrapperResponse<UserResponse>> findById(@PathVariable String id) {
        UserResponse userResponse = UserResponse.fromDomain(findUserByIdUseCase.execute(id));
        //Envolvendo a respuesta
        WrapperResponse<UserResponse> response = WrapperResponse.<UserResponse>builder()
                .status("OK")
                .timestamp(LocalDateTime.now().toString())
                .data(userResponse)
                .build();

        return ResponseEntity.ok(response);
    }
    @DeleteMapping("{id}")
    @Override
    public ResponseEntity<Void> delete(@PathVariable String id) {
        deleteUserUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }

}
