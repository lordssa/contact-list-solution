package com.bravi.crud.repository.converter;

import com.bravi.crud.domain.Contact;
import com.bravi.crud.repository.model.ContactDB;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class ContactToContactDBConverter {
    private final ModelMapper modelMapper;

    public ContactDB convert(Contact contact){
        return modelMapper.map(contact, ContactDB.class);
    }
}
