package com.bravi.crud.controller.converter;

import com.bravi.crud.controller.resource.ContactResource;
import com.bravi.crud.domain.Contact;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class ContactToContactResourceConverter {
    private final ModelMapper modelMapper;

    public ContactResource convert(Contact contact){
        return modelMapper.map(contact, ContactResource.class);
    }
}
