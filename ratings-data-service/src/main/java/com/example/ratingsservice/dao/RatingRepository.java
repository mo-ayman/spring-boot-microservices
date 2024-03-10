package com.example.ratingsservice.dao;

import com.example.ratingsservice.models.Rating;
import com.example.ratingsservice.models.RatingTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<RatingTable, Long> {
    @Query("SELECT new com.example.ratingsservice.models.Rating(r.movieId, r.rating) FROM RatingTable r WHERE r.userId = :userId")
    List<Rating> findRatingsByUserId(@Param("userId") String userId);
}
