package com.example.movieinfoservice.dao;

import com.example.movieinfoservice.models.MovieSummary;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MovieRepository extends MongoRepository<MovieSummary, String> {

    Optional<MovieSummary> findById(String id);
}

