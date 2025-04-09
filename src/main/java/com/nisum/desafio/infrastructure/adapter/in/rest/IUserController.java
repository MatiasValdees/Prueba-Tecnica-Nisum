package com.nisum.desafio.infrastructure.adapter.in.rest;

import com.nisum.desafio.infrastructure.adapter.in.rest.dtos.WrapperResponse;
import com.nisum.desafio.infrastructure.adapter.in.rest.dtos.user.UserCreateRequest;
import com.nisum.desafio.infrastructure.adapter.in.rest.dtos.user.UserResponse;
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

    @Operation(summary = "Buscar Usuario por ID",description = "Busca un Usuario por su ID",responses = {
            @ApiResponse(responseCode = "200",description = "Usuario encontrada",content = @Content(mediaType = "application/json",schema = @Schema(implementation = UserResponse.class))),
            @ApiResponse(responseCode = "404",description = "Usuario no encontrada",content = @Content(mediaType = "application/json",schema = @Schema(implementation = ExceptionResponse.class)))
    })
    ResponseEntity<WrapperResponse<UserResponse>> findById(String id);

    @Operation(summary = "Eliminar Usuario",description = "Elimina un Usuario existente por id",responses = {
            @ApiResponse(responseCode = "204",description = "Usuario eliminado exitosamente",content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404",description = "Usuario no encontrado",content = @Content(mediaType = "application/json",schema = @Schema(implementation = ExceptionResponse.class)))
    })
    ResponseEntity<WrapperResponse<String>> delete(String id);


    @Operation(summary = "Listar Usuarios",description = "Lista todos los usuarios",responses = {
            @ApiResponse(responseCode = "200",description = "Usuarios encontrados",content = @Content(mediaType = "application/json",schema = @Schema(implementation = UserResponse[].class))),
    })
    ResponseEntity<WrapperResponse<List<UserResponse>>>readAll();
}
