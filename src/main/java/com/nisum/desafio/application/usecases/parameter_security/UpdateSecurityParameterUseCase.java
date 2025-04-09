package com.nisum.desafio.application.usecases.parameter_security;

import com.nisum.desafio.domain.models.SecurityParameter;
import com.nisum.desafio.domain.ports.in.usecases.parameter.IFindSecurityParameterFindByIdUseCase;
import com.nisum.desafio.domain.ports.in.usecases.parameter.IUpdateSecurityParameterUseCase;
import com.nisum.desafio.domain.ports.out.repositories.ISecurityParameterRepository;
import com.nisum.desafio.shared.annotations.UseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@UseCase
@RequiredArgsConstructor
@Slf4j
public class UpdateSecurityParameterUseCase implements IUpdateSecurityParameterUseCase {
    private final IFindSecurityParameterFindByIdUseCase findSecurityParameterFindByIdUseCase;
    private final ISecurityParameterRepository repository;
    @Override
    public SecurityParameter execute(SecurityParameter securityParameter) {
        log.info("Saving security parameter with id: {}", securityParameter.getId());
        var security=findSecurityParameterFindByIdUseCase.execute(securityParameter.getId());
        security.setLowerCase(securityParameter.isLowerCase());
        security.setUpperCase(securityParameter.isUpperCase());
        security.setSpecialCharacter(securityParameter.isSpecialCharacter());
        security.setNumber(securityParameter.isNumber());
        security.setMinLength(securityParameter.getMinLength());
        security.setMaxLength(securityParameter.getMaxLength());
        return repository.save(security);
    }
}
