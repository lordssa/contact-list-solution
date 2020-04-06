package com.bravi.crud.repository;

import com.bravi.crud.repository.model.ContactDB;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactRepository extends MongoRepository<ContactDB, String> {
}
