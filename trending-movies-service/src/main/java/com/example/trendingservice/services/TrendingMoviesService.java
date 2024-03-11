package com.example.trendingservice.services;

import com.example.trendingservice.proto.TrendingMoviesGrpc;
import com.example.trendingservice.proto.TrendingMoviesOuterClass;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

@GrpcService
public class TrendingMoviesService extends TrendingMoviesGrpc.TrendingMoviesImplBase {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void getTopTenMovies(TrendingMoviesOuterClass.Empty request, StreamObserver<TrendingMoviesOuterClass.GetTopTenMoviesReply> responseObserver) {
        TrendingMoviesOuterClass.GetTopTenMoviesReply.Builder response = TrendingMoviesOuterClass.GetTopTenMoviesReply.newBuilder();

        // Pass rest template to the service
        RatingService ratingService = new RatingService(restTemplate);

        System.out.println(ratingService.getTrendingMovies());

        response.addMovieRatings(TrendingMoviesOuterClass.MovieRating.newBuilder().setMovieId("27205").setRating(5).build());

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}

