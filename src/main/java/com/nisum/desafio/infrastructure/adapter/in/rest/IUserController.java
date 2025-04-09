package com.nisum.desafio.infrastructure.adapter.in.rest;

import com.nisum.desafio.infrastructure.adapter.in.rest.dtos.WrapperResponse;
import com.nisum.desafio.infrastructure.adapter.in.rest.dtos.user.UserCreateRequest;
import com.nisum.desafio.infrastructure.adapter.in.rest.dtos.user.UserResponse;
import com.nisum.desafio.infrastructure.adapter.in.rest.dtos.user.UserUpdateRequest;
import com.nisum.desafio.infrastructure.exceptions.dto.ExceptionResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "User", description = "CRUD USER")
public interface IUserController {
    @Operation(summary = "Crear Usuario",description = "Crea un nuevo Usuario",responses = {
            @ApiResponse(responseCode = "201",description = "Usuario creado exitosamente",content = @Content(mediaType = "application/json",schema = @Schema(implementation = UserResponse.class))),
            @ApiResponse(responseCode = "400",description = "Bad Request",content = @Content(mediaType = "application/json",schema = @Schema(implementation = ExceptionResponse.class))),
            @ApiResponse(responseCode = "404",description = "Codigo City/Country no encontrado",content = @Content(mediaType = "application/json",schema = @Schema(implementation = ExceptionResponse.class)))
    })
    ResponseEntity<WrapperResponse<UserResponse>>create(UserCreateRequest request);

    ResponseEntity<WrapperResponse<UserResponse>> findById(String id);
    ResponseEntity<WrapperResponse<String>> delete(String id);
    ResponseEntity<WrapperResponse<List<UserResponse>>>readAll();
}
