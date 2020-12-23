package com.thiagofialho.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.thiagofialho.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
