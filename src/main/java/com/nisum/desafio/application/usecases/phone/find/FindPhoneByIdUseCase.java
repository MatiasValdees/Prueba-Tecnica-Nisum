package com.nisum.desafio.application.usecases.phone.find;

import com.nisum.desafio.domain.exceptions.EntityNotFoundException;
import com.nisum.desafio.domain.models.phone.Phone;
import com.nisum.desafio.domain.ports.in.usecases.phone.find.IFindPhoneByIdUseCase;
import com.nisum.desafio.domain.ports.out.repositories.IPhoneRepository;
import com.nisum.desafio.shared.annotations.UseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static com.nisum.desafio.domain.models.constants.NisumConstant.PHONE_CONSTANT;

/**
 * Caso de uso para la validacion de un telefono por id.
 * Usado por caso de uso ***ELIMINAR TELEFONO***.
 * Usado por caso de uso ***ACTUALIZAR TELEFONO***.
 */

@UseCase
@RequiredArgsConstructor
@Slf4j
public class FindPhoneByIdUseCase implements IFindPhoneByIdUseCase {
    private final IPhoneRepository repository;
    @Override
    public Phone execute(Long id) {
        log.info("Finding phone by id: {}", id);
        var phone = repository.findById(id);
        if(phone==null){
            log.warn("Phone not found with id: {}", id);
            throw new EntityNotFoundException(PHONE_CONSTANT, "id", id.toString());
        }
        return phone;
    }
}
