package com.moviecatalogservice.services;

import com.moviecatalogservice.models.*;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieInfoService {

    private final RestTemplate restTemplate;

    public MovieInfoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "getFallbackCatalogItem",
            threadPoolKey = "movieInfoPool",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "20"),  // Size of thread pool
                    @HystrixProperty(name = "maxQueueSize", value = "10")   // Waiting in thread queue
            },
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
    public CatalogItem getCatalogItem(Rating rating) {
        String movieDetailsUrl = "http://movie-info-service/movies/" + rating.getMovieId();
        Movie movie = this.restTemplate.getForObject(movieDetailsUrl, Movie.class);
        assert movie != null;
        return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
    }

    public CatalogItem getFallbackCatalogItem(Rating rating) {
        return new CatalogItem("Movie name not found", "", rating.getRating());
    }

    @HystrixCommand(fallbackMethod = "getFallbackCatalogTrendingItem",
            threadPoolKey = "movieInfoPool",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "20"),  // Size of thread pool
                    @HystrixProperty(name = "maxQueueSize", value = "10")   // Waiting in thread queue
            },
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
    public CatalogTrendingItem getCatalogTrendingItem(AverageRating rating) {
        String movieDetailsUrl = "http://movie-info-service/movies/" + rating.getMovieId();
        Movie movie = this.restTemplate.getForObject(movieDetailsUrl, Movie.class);
        assert movie != null;
        return new CatalogTrendingItem(movie.getName(), movie.getDescription(), rating.getRating());
    }

    public CatalogTrendingItem getFallbackCatalogTrendingItem(AverageRating rating) {
        return new CatalogTrendingItem("Movie name not found", "", rating.getRating());
    }
}
