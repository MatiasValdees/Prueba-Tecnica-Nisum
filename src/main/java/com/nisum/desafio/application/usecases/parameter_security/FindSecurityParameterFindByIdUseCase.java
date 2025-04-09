package com.nisum.desafio.application.usecases.parameter_security;

import com.nisum.desafio.domain.exceptions.EntityNotFoundException;
import com.nisum.desafio.domain.models.SecurityParameter;
import com.nisum.desafio.domain.ports.in.usecases.parameter.IFindSecurityParameterFindByIdUseCase;
import com.nisum.desafio.domain.ports.out.repositories.ISecurityParameterRepository;
import com.nisum.desafio.shared.annotations.UseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static com.nisum.desafio.domain.models.constants.NisumConstant.PARAMETER_SECURITY_CONSTANT;

@UseCase
@RequiredArgsConstructor
@Slf4j
public class FindSecurityParameterFindByIdUseCase implements IFindSecurityParameterFindByIdUseCase {
    private final ISecurityParameterRepository repository;

    @Override
    public SecurityParameter execute(Long id) {
        log.info("Finding security parameter by id: {} from repository", id);
        var security= repository.findById(id);
        if (security == null) {
            log.warn("Security parameter with id: {} not found", id);
            throw new EntityNotFoundException(PARAMETER_SECURITY_CONSTANT,"id", id.toString());
        }
        return security;
    }
}
