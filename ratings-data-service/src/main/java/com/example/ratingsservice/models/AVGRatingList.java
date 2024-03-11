package com.example.ratingsservice.models;

import java.util.List;

public class AVGRatingList {
    private List<AVGRating> ratings;

    public AVGRatingList() {
    }

    public AVGRatingList(List<AVGRating> ratings) {
        this.ratings = ratings;
    }

    public List<AVGRating> getAvgRatings() {
        return ratings;
    }

    public void setAvgRatings(List<AVGRating> avgRatings) {
        this.ratings = avgRatings;
    }
}
