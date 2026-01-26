package com.ruudschroen.proficiency.intermediate.movies.omdb;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ruudschroen.proficiency.intermediate.movies.MovieRating;
import com.ruudschroen.proficiency.intermediate.movies.MovieRatingDto;

import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
public class OmdbMovieRatingDto implements MovieRatingDto {
    private final String name;
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