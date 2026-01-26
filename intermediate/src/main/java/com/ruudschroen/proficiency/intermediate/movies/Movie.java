package com.ruudschroen.proficiency.intermediate.movies;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public record Movie(String title, String year, String rated, String released, String runtime, String[] genres,
        String director, String[] writers, String[] actors, String plot, String language, String country, String awards,
        String poster, MovieRating[] ratings, String metascore, String imdbRating, String imdbVotes, String imdbId,
        String type, String dvd, String boxOffice, String production, String website, String response) {
}
