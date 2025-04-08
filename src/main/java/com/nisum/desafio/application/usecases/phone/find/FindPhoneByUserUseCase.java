package com.nisum.desafio.application.usecases.phone.find;

import com.nisum.desafio.domain.models.phone.Phone;
import com.nisum.desafio.domain.ports.in.usecases.phone.find.IFindPhoneByUserUseCase;
import com.nisum.desafio.domain.ports.out.repositories.IPhoneRepository;
import com.nisum.desafio.shared.annotations.UseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@UseCase
@RequiredArgsConstructor
@Slf4j
public class FindPhoneByUserUseCase implements IFindPhoneByUserUseCase {
    private final IPhoneRepository repository;

    @Override
    public List<Phone> execute(String userId) {
        log.info("Finding phones for user with ID: {}", userId);
        var list= repository.findByUserId(userId);
        log.info("phone founds: {}", list.size());
        return list;
    }
}
