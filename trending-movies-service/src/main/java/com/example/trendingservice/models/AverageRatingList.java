package com.example.trendingservice.models;

import java.util.List;

public class AverageRatingList {
    private List<AverageRating> ratings;

    public AverageRatingList() {
    }

    public AverageRatingList(List<AverageRating> ratings) {
        this.ratings = ratings;
    }

    public List<AverageRating> getAvgRatings() {
        return ratings;
    }

    public void setAvgRatings(List<AverageRating> averageRatings) {
        this.ratings = averageRatings;
    }
}
