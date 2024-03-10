package com.example.ratingsservice.services;

import com.example.ratingsservice.dao.RatingRepository;
import com.example.ratingsservice.models.UserRating;

import org.springframework.stereotype.Service;

@Service
public class RatingService {
    private final RatingRepository ratingRepository;

    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public UserRating getUserRating(String userId) {
        return new UserRating(ratingRepository.findRatingsByUserId(userId));
    }
}
