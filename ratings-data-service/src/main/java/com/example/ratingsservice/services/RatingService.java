package com.example.ratingsservice.services;

import com.example.ratingsservice.dao.RatingRepository;
import com.example.ratingsservice.models.AVGRating;
import com.example.ratingsservice.models.AVGRatingList;
import com.example.ratingsservice.models.UserRating;

import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Math.min;

@Service
public class RatingService {
    private final RatingRepository ratingRepository;

    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public UserRating getUserRating(String userId) {
        return new UserRating(ratingRepository.findRatingsByUserId(userId));
    }

    public AVGRatingList getTopRatings(int count) {
        List<AVGRating> topRatings = ratingRepository.findTopRatings();
        return new AVGRatingList(topRatings.subList(0, min(count, topRatings.size())));
    }
}
