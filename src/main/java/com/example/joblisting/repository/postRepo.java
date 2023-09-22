package com.example.joblisting.repository;

import com.example.joblisting.model.Post;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface postRepo extends MongoRepository<Post,String>
{

}
