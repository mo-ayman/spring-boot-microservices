package com.moviecatalogservice.services;

import com.moviecatalogservice.models.AverageRating;
import com.moviecatalogservice.proto.TrendingMoviesGrpc;
import com.moviecatalogservice.proto.TrendingMoviesOuterClass;
import com.netflix.discovery.EurekaClient;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrpcClientService {

    @Autowired
    private EurekaClient client;

    public List<AverageRating> getTopTenMovies() {
        try {
            final ManagedChannel channel = ManagedChannelBuilder.forAddress("192.168.56.1", 9090).usePlaintext().build();
            final TrendingMoviesGrpc.TrendingMoviesBlockingStub trendingMoviesBlockingStub = TrendingMoviesGrpc.newBlockingStub(channel);

            TrendingMoviesOuterClass.Empty empty = TrendingMoviesOuterClass.Empty.newBuilder().build();
            final TrendingMoviesOuterClass.GetTopTenMoviesReply apiResponse = trendingMoviesBlockingStub.getTopTenMovies(empty);
            return apiResponse.getMovieRatingsList().stream().map(m -> new AverageRating(m.getMovieId(), m.getRating())).collect(java.util.stream.Collectors.toList());
        } catch (final StatusRuntimeException e) {
            throw new RuntimeException("FAILED with " + e.getStatus().getCode().name());
        }
    }
}