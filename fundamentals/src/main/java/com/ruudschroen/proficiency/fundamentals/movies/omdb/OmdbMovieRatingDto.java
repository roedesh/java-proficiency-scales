package com.ruudschroen.proficiency.fundamentals.movies.omdb;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ruudschroen.proficiency.fundamentals.movies.MovieRating;
import com.ruudschroen.proficiency.fundamentals.movies.MovieRatingData;

import lombok.Getter;
import lombok.experimental.Accessors;
import lombok.extern.jackson.Jacksonized;

@Getter
@Accessors(fluent = true)
@Jacksonized
public class OmdbMovieRatingDto implements MovieRatingData {
    @JsonProperty("Name")
    private final String name;

    @JsonProperty("Score")
    private final String score;

    @JsonCreator
    public OmdbMovieRatingDto(
            @JsonProperty("Source") String name,
            @JsonProperty("Value") String score) {
        this.name = name;
        this.score = score;
    }

    public MovieRating toMovieRating() {
        return new MovieRating(name, score);
    }
}
