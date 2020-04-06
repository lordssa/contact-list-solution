package com.bravi.crud.repository.converter;

import com.bravi.crud.domain.Contact;
import com.bravi.crud.repository.model.ContactDB;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class ContactDBToContactConverter {
    private final ModelMapper modelMapper;

    public Contact convert(ContactDB contactDB){
        return modelMapper.map(contactDB, Contact.class);
    }
}
