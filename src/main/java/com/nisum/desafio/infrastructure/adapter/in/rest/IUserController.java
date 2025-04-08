package com.nisum.desafio.infrastructure.adapter.in.rest;

import com.nisum.desafio.infrastructure.adapter.in.rest.dtos.WrapperResponse;
import com.nisum.desafio.infrastructure.adapter.in.rest.dtos.user.UserCreateRequest;
import com.nisum.desafio.infrastructure.adapter.in.rest.dtos.user.UserResponse;
import com.nisum.desafio.infrastructure.adapter.in.rest.dtos.user.UserUpdateRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserController {

    ResponseEntity<WrapperResponse<UserResponse>>create(UserCreateRequest request);
    ResponseEntity<WrapperResponse<UserResponse>> findById(String id);
    ResponseEntity<WrapperResponse<UserResponse>> update(UserUpdateRequest request);
    ResponseEntity<Void> delete(String id);
    ResponseEntity<WrapperResponse<List<UserResponse>>>readAll();
}
