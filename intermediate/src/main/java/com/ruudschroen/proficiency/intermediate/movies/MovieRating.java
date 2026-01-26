package com.ruudschroen.proficiency.intermediate.movies;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieRating {
    private final String name;
    private final String score;

    public MovieRating(String name, String score) {
        this.name = name;
        this.score = score;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("score")
    public String getScore() {
        return score;
    }
}
