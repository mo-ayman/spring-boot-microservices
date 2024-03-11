package com.example.trendingservice.services;

import com.example.trendingservice.models.AVGRating;
import com.example.trendingservice.proto.TrendingMoviesGrpc;
import com.example.trendingservice.proto.TrendingMoviesOuterClass;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@GrpcService
public class TrendingMoviesService extends TrendingMoviesGrpc.TrendingMoviesImplBase {

//    @Autowired
//    private RestTemplate restTemplate;

    private final RestTemplate restTemplate;

    public TrendingMoviesService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void getTopTenMovies(TrendingMoviesOuterClass.Empty request, StreamObserver<TrendingMoviesOuterClass.GetTopTenMoviesReply> responseObserver) {
        TrendingMoviesOuterClass.GetTopTenMoviesReply.Builder response = TrendingMoviesOuterClass.GetTopTenMoviesReply.newBuilder();
        
        RatingService ratingService = new RatingService(restTemplate);

        List<AVGRating> topRatings = ratingService.getTrendingMovies().getAvgRatings();

        for (AVGRating rating : topRatings) {
            response.addMovieRatings(TrendingMoviesOuterClass.MovieRating.newBuilder().setMovieId(rating.getMovieId()).setRating((float) rating.getAvgRating()).build());
        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}

