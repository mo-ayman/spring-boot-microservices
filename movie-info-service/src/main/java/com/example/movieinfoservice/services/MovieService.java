package com.example.movieinfoservice.services;

import com.example.movieinfoservice.dao.MovieRepository;
import com.example.movieinfoservice.models.Movie;
import com.example.movieinfoservice.models.MovieSummary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieService {

    @Value("${api.key}")
    private String apiKey;
    private final MongoTemplate mongoTemplate;
    private final RestTemplate restTemplate;

    public MovieService(MovieRepository movieRepository, MongoTemplate mongoTemplate, RestTemplate restTemplate) {
        this.mongoTemplate = mongoTemplate;
        this.restTemplate = restTemplate;

    }

    public Movie getMovieInfo(String movieId) {
        // Get the movie info from TMDB

        MovieSummary movieSummary = getFromDB(movieId);
        if (movieSummary == null) {
            movieSummary = getFromAPI(movieId);
            saveToDB(movieSummary);
        }
        return new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());
    }

    private MovieSummary getFromAPI(String movieId) {
        final String url = "https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey;
        return restTemplate.getForObject(url, MovieSummary.class);
    }

    private void saveToDB(MovieSummary movieSummary) {
        mongoTemplate.save(movieSummary);
    }

    private MovieSummary getFromDB(String movieId) {
        return mongoTemplate.findById(movieId, MovieSummary.class);
    }


}


