package com.bravi.crud.usecase.people.impl;

import com.bravi.crud.domain.People;
import com.bravi.crud.repository.PeopleRepository;
import com.bravi.crud.repository.converter.PeopleDBToPeopleConverter;
import com.bravi.crud.repository.converter.PeopleToPeopleDBConverter;
import com.bravi.crud.repository.model.PeopleDB;
import com.bravi.crud.usecase.people.GetPeopleUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class GetPeople implements GetPeopleUseCase {

    private PeopleRepository peopleRepository;
    private PeopleToPeopleDBConverter peopleToPeopleDBConverter;
    private PeopleDBToPeopleConverter peopleDBToPeopleConverter;

    @Override
    public People execute(People people) {
        return Optional.ofNullable(people)
                .map(peopleToPeopleDBConverter::convert)
                .map(PeopleDB::getId)
                .flatMap(peopleRepository::findById)
                .map(peopleDBToPeopleConverter::convert)
                .orElse(People.builder().build());
    }
}
