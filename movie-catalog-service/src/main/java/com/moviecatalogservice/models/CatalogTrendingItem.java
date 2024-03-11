package com.moviecatalogservice.models;

public class CatalogTrendingItem {

    private String name;
    private String description;
    private float rating;

    public CatalogTrendingItem() {

    }

    public CatalogTrendingItem(String name, String description, float rating) {
        this.name = name;
        this.description = description;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
