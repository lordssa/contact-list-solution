package com.bravi.crud.repository.converter;

import com.bravi.crud.domain.People;
import com.bravi.crud.repository.model.PeopleDB;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class PeopleToPeopleDBConverter {
    private final ModelMapper modelMapper;

    public PeopleDB convert(People people){
        return modelMapper.map(people, PeopleDB.class);
    }
}
