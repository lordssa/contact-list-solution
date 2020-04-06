package com.bravi.crud.usecase.contact.impl;

import com.bravi.crud.repository.ContactRepository;
import com.bravi.crud.usecase.contact.DeleteContactUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteContact implements DeleteContactUseCase {

    private ContactRepository contactRepository;

    @Override
    public void execute(String id) {
        contactRepository.deleteById(id);
    }
}
