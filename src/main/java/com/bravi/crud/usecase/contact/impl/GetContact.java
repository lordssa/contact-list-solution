package com.bravi.crud.usecase.contact.impl;

import com.bravi.crud.domain.Contact;
import com.bravi.crud.domain.Contact;
import com.bravi.crud.repository.ContactRepository;
import com.bravi.crud.repository.converter.ContactDBToContactConverter;
import com.bravi.crud.repository.converter.ContactToContactDBConverter;
import com.bravi.crud.repository.model.ContactDB;
import com.bravi.crud.usecase.contact.GetContactUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class GetContact implements GetContactUseCase {

    private ContactRepository contactRepository;
    private ContactToContactDBConverter contactToContactDBConverter;
    private ContactDBToContactConverter contactDBToContactConverter;

    @Override
    public Contact execute(Contact contact) {
        return Optional.ofNullable(contact)
                .map(contactToContactDBConverter::convert)
                .map(ContactDB::getId)
                .flatMap(contactRepository::findById)
                .map(contactDBToContactConverter::convert)
                .orElse(Contact.builder().build());
    }
}
