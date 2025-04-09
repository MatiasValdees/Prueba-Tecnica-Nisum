package com.nisum.desafio.infrastructure.adapter.in.rest;

import com.nisum.desafio.infrastructure.adapter.in.rest.dtos.WrapperResponse;
import com.nisum.desafio.infrastructure.adapter.in.rest.dtos.security_parameter.SecurityParameterResponse;
import com.nisum.desafio.infrastructure.adapter.in.rest.dtos.security_parameter.SecurityParameterUpdateRequest;
import com.nisum.desafio.infrastructure.exceptions.dto.ExceptionResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Security Parameter",description = "Leer y Actualizar Parameter Security")
public interface ISecurityParameterController {
    @Operation(summary = "Parametros de seguridad",description = "retorna el parametro de seguridad por defecto",responses = {
            @ApiResponse(responseCode = "200",description = "Parametro de Seguridad encontrado",content = @Content(mediaType = "application/json",schema = @Schema(implementation = SecurityParameterResponse.class))),
            @ApiResponse(responseCode = "404",description = "Parametro de Seguridad no encontrado",content = @Content(mediaType = "application/json",schema = @Schema(implementation = ExceptionResponse.class)))
    })
    ResponseEntity<WrapperResponse<SecurityParameterResponse>> find();

    @Operation(summary = "Actualizar Parametro de Seguridad",description = "Actualiza el parametro de seguridad por defecto",responses = {
            @ApiResponse(responseCode = "200",description = "Parametro de Seguridad actualizado",content = @Content(mediaType = "application/json",schema = @Schema(implementation = SecurityParameterResponse.class))),
            @ApiResponse(responseCode = "404",description = "Parametro de Seguridad no encontrado",content = @Content(mediaType = "application/json",schema = @Schema(implementation = ExceptionResponse.class)))
    })
    ResponseEntity<WrapperResponse<SecurityParameterResponse>>update(SecurityParameterUpdateRequest request);

}
