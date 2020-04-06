package com.bravi.crud.usecase.exception;

import lombok.Getter;

@Getter
public class PeopleNotFoundException extends RuntimeException {
    public PeopleNotFoundException(String error) {
        super(error);
    }
}