package com.example.trendingservice.services;

import com.example.trendingservice.models.AverageRatingList;
import com.example.trendingservice.models.AverageRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class RatingService {

    private final RestTemplate restTemplate;

    public RatingService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "getFallbackTrendingMovies",
            commandProperties = {
                    // Time to cause timeout
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
                    // N, Hystrix looks at (analyzes) last N requests.
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
                    // if >= 50 percent of the last N requests fail, break the circuit
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
                    // Wait/Sleep for 5 seconds before sending another request to the failed service
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
            })
    public AverageRatingList getTrendingMovies() {
        String ratingsUrl = "http://ratings-data-service/ratings/top/10";
        return Objects.requireNonNull(restTemplate.getForObject(ratingsUrl, AverageRatingList.class));
    }

    public AverageRating getFallbackTrendingMovies() {
        AverageRating rating = new AverageRating();
        rating.setMovieId("0");
        rating.setAvgRating(0);

        return rating;
    }
}
