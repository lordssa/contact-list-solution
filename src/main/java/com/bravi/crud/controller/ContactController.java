package com.bravi.crud.controller;

import com.bravi.crud.controller.converter.ContactResourceToContactConverter;
import com.bravi.crud.controller.converter.ContactToContactResourceConverter;
import com.bravi.crud.controller.resource.ContactResource;
import com.bravi.crud.usecase.contact.AddContactUseCase;
import com.bravi.crud.usecase.contact.DeleteContactUseCase;
import com.bravi.crud.usecase.contact.GetContactUseCase;
import com.bravi.crud.usecase.contact.UpdateContactUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static java.util.Optional.ofNullable;

@Validated
@AllArgsConstructor
@RestController
@RequestMapping("/v1/contact")
public class ContactController {

    private final ContactResourceToContactConverter contactResourceToContactConverter;
    private final ContactToContactResourceConverter contactToContactResourceConverter;
    private final AddContactUseCase addContactUseCase;
    private final UpdateContactUseCase updateContactUseCase;
    private final GetContactUseCase getContactUseCase;
    private final DeleteContactUseCase deleteContactUseCase;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ContactResource addContact(@RequestBody @Valid final ContactResource request){
        return ofNullable(request)
                .map(contactResourceToContactConverter::convert)
                .map(addContactUseCase::execute)
                .map(contactToContactResourceConverter::convert)
                .orElse(ContactResource.builder().build());
    }

    @PutMapping
    @ResponseStatus(code = HttpStatus.OK)
    public ContactResource updateContact(@RequestBody @Valid final ContactResource request){
        return ofNullable(request)
                .map(contactResourceToContactConverter::convert)
                .map(updateContactUseCase::execute)
                .map(contactToContactResourceConverter::convert)
                .orElse(ContactResource.builder().build());
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public ContactResource getContact(@RequestParam(required = true) String idRequest){
        final var request = ContactResource
                .builder()
                .id(idRequest)
                .build();

        return ofNullable(request)
                .map(contactResourceToContactConverter::convert)
                .map(getContactUseCase::execute)
                .map(contactToContactResourceConverter::convert)
                .orElse(ContactResource.builder().build());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteBlacklistedPlayerById(@PathVariable final String id) {
        deleteContactUseCase.execute(id);
    }
}
