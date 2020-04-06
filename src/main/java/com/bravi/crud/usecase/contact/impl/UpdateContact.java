package com.bravi.crud.usecase.contact.impl;

import com.bravi.crud.domain.Contact;
import com.bravi.crud.repository.ContactRepository;
import com.bravi.crud.repository.converter.ContactDBToContactConverter;
import com.bravi.crud.repository.converter.ContactToContactDBConverter;
import com.bravi.crud.usecase.contact.UpdateContactUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UpdateContact implements UpdateContactUseCase {
    
    private ContactRepository contactRepository;
    private ContactToContactDBConverter contactToContactDBConverter;
    private ContactDBToContactConverter contactDBToContactConverter;

    @Override
    public Contact execute(Contact contact) {
        return Optional.ofNullable(contact)
                .map(contactToContactDBConverter::convert)
                .map(contactRepository::save)
                .map(contactDBToContactConverter::convert)
                .get();
    }
}
