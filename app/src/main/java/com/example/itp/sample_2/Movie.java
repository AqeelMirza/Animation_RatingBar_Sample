package com.example.itp.sample_2;

/**
 * Created by ITP on 6/16/2017.
 */

public class Movie {
    String name;

    String rating;

    public Movie(String name, String rating) {
        this.name = name;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
