package com.nisum.desafio.application.usecases.phone;

import com.nisum.desafio.domain.ports.in.usecases.phone.IDeletePhoneUseCase;
import com.nisum.desafio.domain.ports.in.usecases.phone.find.IFindPhoneByIdUseCase;
import com.nisum.desafio.domain.ports.out.repositories.IPhoneRepository;
import com.nisum.desafio.shared.annotations.UseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@UseCase
@RequiredArgsConstructor
@Slf4j
public class DeletePhoneUseCase implements IDeletePhoneUseCase {
    private final IPhoneRepository repository;
    private final IFindPhoneByIdUseCase findPhoneByIdUseCase;

    @Override
    public void execute(Long id) {
        log.info("Deleting phone with id: {}", id);
        findPhoneByIdUseCase.execute(id);
        repository.deleteById(id);
        log.info("Phone with id: {} deleted successfully", id);
    }
}
