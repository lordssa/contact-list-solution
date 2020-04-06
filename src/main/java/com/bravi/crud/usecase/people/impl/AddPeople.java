package com.bravi.crud.usecase.people.impl;

import com.bravi.crud.domain.People;
import com.bravi.crud.repository.PeopleRepository;
import com.bravi.crud.repository.converter.PeopleDBToPeopleConverter;
import com.bravi.crud.repository.converter.PeopleToPeopleDBConverter;
import com.bravi.crud.usecase.people.AddPeopleUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AddPeople implements AddPeopleUseCase {

    private PeopleRepository peopleRepository;
    private PeopleToPeopleDBConverter peopleToPeopleDBConverter;
    private PeopleDBToPeopleConverter peopleDBToPeopleConverter;

    @Override
    public People execute(People people) {
        return Optional.ofNullable(people)
                .map(peopleToPeopleDBConverter::convert)
                .map(peopleRepository::insert)
                .map(peopleDBToPeopleConverter::convert)
                .get();
    }
}
