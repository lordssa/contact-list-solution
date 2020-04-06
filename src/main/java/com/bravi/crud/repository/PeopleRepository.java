package com.bravi.crud.repository;

import com.bravi.crud.repository.model.PeopleDB;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PeopleRepository extends MongoRepository<PeopleDB, String> {
}
