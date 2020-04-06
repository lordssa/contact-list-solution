package com.bravi.crud.usecase.contact.impl;

import com.bravi.crud.controller.exception.TypeContactNotFoundException;
import com.bravi.crud.domain.Contact;
import com.bravi.crud.repository.ContactRepository;
import com.bravi.crud.repository.converter.ContactDBToContactConverter;
import com.bravi.crud.repository.converter.ContactToContactDBConverter;
import com.bravi.crud.usecase.contact.AddContactUseCase;
import com.bravi.crud.usecase.people.GetPeopleUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Optional.ofNullable;

@Service
@AllArgsConstructor
public class AddContact implements AddContactUseCase {

    private ContactRepository contactRepository;
    private ContactToContactDBConverter contactToContactDBConverter;
    private ContactDBToContactConverter contactDBToContactConverter;
    private GetPeopleUseCase getPeopleUseCase;

    @Override
    public Contact execute(Contact contact) {
        return ofNullable(contact)
                .map(this::recoverPeople)
                .map(contactToContactDBConverter::convert)
                .stream()
                .peek(System.out::println)
                .map(contactRepository::insert)
                .peek(System.out::println)
                .findFirst()
                .map(contactDBToContactConverter::convert)
                .get();
    }

    private Contact recoverPeople(Contact contact){

        final var peopleFromDB = ofNullable(contact.getPeople())
                .map(getPeopleUseCase::execute)
                .orElseThrow(() -> new TypeContactNotFoundException("People not found on database."));

        return contact
                .toBuilder()
                .people(peopleFromDB)
                .build();
    }
}
