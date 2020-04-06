package com.bravi.crud.controller.converter;

import com.bravi.crud.controller.resource.PeopleResource;
import com.bravi.crud.domain.People;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PeopleResourceToPeopleConverter {

    private final ModelMapper modelMapper;

    public People convert(PeopleResource peopleResource){
        return modelMapper.map(peopleResource, People.class);
    }
}
