package com.moviecatalogservice.models;

public class AverageRating {

    private String movieId;
    private float rating;

    public AverageRating() {
    }

    public AverageRating(String movieId, float rating) {
        this.movieId = movieId;
        this.rating = rating;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
