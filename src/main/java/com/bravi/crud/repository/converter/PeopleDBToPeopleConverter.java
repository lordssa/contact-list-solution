package com.bravi.crud.repository.converter;

import com.bravi.crud.domain.People;
import com.bravi.crud.repository.model.PeopleDB;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class PeopleDBToPeopleConverter {
    private final ModelMapper modelMapper;

    public People convert(PeopleDB peopleDB){
        return modelMapper.map(peopleDB, People.class);
    }
}
