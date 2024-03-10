package com.example.ratingsservice.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ratings")
public class RatingTable {

    @Id
    private Long id;
    private String userId;
    private String movieId;
    private int rating;


    public RatingTable() {
    }

    public RatingTable(String movieId, int rating) {
        this.movieId = movieId;
        this.rating = rating;
    }

    public RatingTable(String movieId, int rating, String userId) {
        this.movieId = movieId;
        this.rating = rating;
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
