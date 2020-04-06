package com.bravi.crud.usecase.people.impl;

import com.bravi.crud.repository.PeopleRepository;
import com.bravi.crud.usecase.people.DeletePeopleUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeletePeople implements DeletePeopleUseCase {

    private PeopleRepository peopleRepository;

    @Override
    public void execute(String id) {
        peopleRepository.deleteById(id);
    }
}
