package com.bravi.crud.controller.converter;

import com.bravi.crud.controller.resource.ContactResource;
import com.bravi.crud.domain.Contact;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class ContactResourceToContactConverter {
    private final ModelMapper modelMapper;

    public Contact convert(ContactResource contactResource){
        return modelMapper.map(contactResource, Contact.class);
    }
}
