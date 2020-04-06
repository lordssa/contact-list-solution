package com.bravi.crud.usecase.people.impl;

import com.bravi.crud.domain.People;
import com.bravi.crud.repository.PeopleRepository;
import com.bravi.crud.repository.converter.PeopleDBToPeopleConverter;
import com.bravi.crud.repository.converter.PeopleToPeopleDBConverter;
import com.bravi.crud.usecase.people.UpdatePeopleUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UpdatePeople implements UpdatePeopleUseCase {

    private PeopleRepository peopleRepository;
    private PeopleToPeopleDBConverter peopleToPeopleDBConverter;
    private PeopleDBToPeopleConverter peopleDBToPeopleConverter;

    @Override
    public People execute(People people) {
        return Optional.ofNullable(people)
                .map(peopleToPeopleDBConverter::convert)
                .map(peopleRepository::save)
                .map(peopleDBToPeopleConverter::convert)
                .get();
    }
}
