package com.example.ratingsservice.resources;

import com.example.ratingsservice.models.AverageRatingList;
import com.example.ratingsservice.models.UserRating;
import com.example.ratingsservice.services.RatingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/ratings")
public class RatingsResource {

    private final RatingService ratingService;

    public RatingsResource(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    // get the ratings of a user
    @GetMapping("/{userId}")
    public UserRating getRatingsOfUser(@PathVariable String userId) {
        return ratingService.getUserRating(userId);
    }
    // get the top movies by ratings
    @GetMapping("/top/{count}")
    public AverageRatingList getTopRatings(@PathVariable int count) {
        return ratingService.getTopRatings(count);
    }
}
