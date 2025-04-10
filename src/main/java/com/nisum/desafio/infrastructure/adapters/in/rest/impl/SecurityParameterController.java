package com.nisum.desafio.infrastructure.adapters.in.rest.impl;

import com.nisum.desafio.domain.ports.in.usecases.parameter.IFindSecurityParameterFindByIdUseCase;
import com.nisum.desafio.domain.ports.in.usecases.parameter.IUpdateSecurityParameterUseCase;
import com.nisum.desafio.infrastructure.adapters.in.rest.ISecurityParameterController;
import com.nisum.desafio.infrastructure.adapters.in.rest.dtos.WrapperResponse;
import com.nisum.desafio.infrastructure.adapters.in.rest.dtos.security_parameter.SecurityParameterResponse;
import com.nisum.desafio.infrastructure.adapters.in.rest.dtos.security_parameter.SecurityParameterUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("security-parameter")
@RequiredArgsConstructor
public class SecurityParameterController implements ISecurityParameterController {
    private final IFindSecurityParameterFindByIdUseCase findSecurityParameterFindByIdUseCase;
    private final IUpdateSecurityParameterUseCase updateSecurityParameterUseCase;

    @GetMapping
    @Override
    public ResponseEntity<WrapperResponse<SecurityParameterResponse>> find() {
        SecurityParameterResponse parameterResponse=SecurityParameterResponse.fromDomain(findSecurityParameterFindByIdUseCase.execute(1L));

        return ResponseEntity.ok(new WrapperResponse<>(parameterResponse));
    }
    @PutMapping
    @Override
    public ResponseEntity<WrapperResponse<SecurityParameterResponse>> update(@RequestBody SecurityParameterUpdateRequest request) {
        SecurityParameterResponse parameterResponse=SecurityParameterResponse.fromDomain(updateSecurityParameterUseCase.execute(request.toDomain()));

        return ResponseEntity.ok(new WrapperResponse<>(parameterResponse));
    }
}
