package com.example.ratingsservice.services;

import com.example.ratingsservice.dao.RatingRepository;
import com.example.ratingsservice.models.Rating;
import com.example.ratingsservice.models.UserRating;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RatingService {
    private final RatingRepository ratingRepository;

    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public UserRating getUserRating(String userId) {
        return new UserRating(ratingRepository.findRatingsByUserId(userId));
    }

    public List<Rating> getTopRatings(int count) {
        List<Object[]> results = ratingRepository.findTopRatings();
        List<Rating> ratings = new ArrayList<>();
        // add count ratings to the list
        for (int i = 0; i < results.size() && i < count; i++) {
            Object[] result = results.get(i);
            ratings.add(new Rating((String) result[0], ((Double) result[1]).intValue()));
        }
        return ratings;
    }
}
