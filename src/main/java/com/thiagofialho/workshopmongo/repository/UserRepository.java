package com.thiagofialho.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.thiagofialho.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
