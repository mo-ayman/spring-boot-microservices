package com.example.ratingsservice.models;

public class AverageRating {
    private String movieId;
    private double avgRating;

    public AverageRating() {
    }

    public AverageRating(String movieId, double avgRating) {
        this.movieId = movieId;
        this.avgRating = avgRating;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }
}
