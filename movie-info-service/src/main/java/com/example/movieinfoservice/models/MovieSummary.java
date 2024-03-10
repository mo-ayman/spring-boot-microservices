package com.example.movieinfoservice.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "movie_db")
public class MovieSummary {

    private String id;
    private String title;
    private String overview;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}
