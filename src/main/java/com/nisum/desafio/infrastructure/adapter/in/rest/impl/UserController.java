package com.nisum.desafio.infrastructure.adapter.in.rest.impl;

import com.nisum.desafio.domain.ports.in.usecases.user.ICreateUserUseCase;
import com.nisum.desafio.domain.ports.in.usecases.user.IDeleteUserUseCase;
import com.nisum.desafio.domain.ports.in.usecases.user.find.IFindAllUserUseCase;
import com.nisum.desafio.domain.ports.in.usecases.user.find.IFindUserByIdUseCase;
import com.nisum.desafio.infrastructure.adapter.in.rest.IUserController;
import com.nisum.desafio.infrastructure.adapter.in.rest.dtos.WrapperResponse;
import com.nisum.desafio.infrastructure.adapter.in.rest.dtos.user.UserCreateRequest;
import com.nisum.desafio.infrastructure.adapter.in.rest.dtos.user.UserResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController implements IUserController {
    private final ICreateUserUseCase createUserUseCase;
    private final IFindUserByIdUseCase findUserByIdUseCase;
    private final IDeleteUserUseCase deleteUserUseCase;
    private final IFindAllUserUseCase findAllUserUseCase;


    @GetMapping
    @Override
    public ResponseEntity<WrapperResponse<List<UserResponse>>> readAll() {
        List<UserResponse> list= findAllUserUseCase.execute().stream().map(UserResponse::fromDomain).toList();

        return ResponseEntity.ok(new WrapperResponse<>(list));
    }
    @PostMapping
    @Override
    public ResponseEntity<WrapperResponse<UserResponse>> create(@Valid @RequestBody UserCreateRequest request) {
        UserResponse userResponse = UserResponse.fromDomain(createUserUseCase.execute(request.toDomain()));

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new WrapperResponse<>(userResponse));
    }
    @GetMapping("findById/{id}")
    @Override
    public ResponseEntity<WrapperResponse<UserResponse>> findById(@PathVariable String id) {
        UserResponse userResponse = UserResponse.fromDomain(findUserByIdUseCase.execute(id));

        return ResponseEntity.ok(new WrapperResponse<>(userResponse));
    }
    @DeleteMapping("{id}")
    @Override
    public ResponseEntity<WrapperResponse<String>> delete(@PathVariable String id) {
        deleteUserUseCase.execute(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body(new WrapperResponse<>("User deleted successfully - id: "+id));
    }

}
