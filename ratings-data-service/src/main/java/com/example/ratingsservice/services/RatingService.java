package com.example.ratingsservice.services;

import com.example.ratingsservice.dao.RatingRepository;
import com.example.ratingsservice.models.AverageRating;
import com.example.ratingsservice.models.AverageRatingList;
import com.example.ratingsservice.models.UserRating;

import org.springframework.data.domain.PageRequest;
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

    public AverageRatingList getTopRatings(int count) {
        List<AverageRating> topRatings = ratingRepository.findTopRatings(PageRequest.of(0, 10));
        return new AverageRatingList(topRatings.subList(0, min(count, topRatings.size())));
    }
}
