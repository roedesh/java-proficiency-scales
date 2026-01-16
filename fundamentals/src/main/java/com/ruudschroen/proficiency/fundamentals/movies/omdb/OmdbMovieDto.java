package com.ruudschroen.proficiency.fundamentals.movies.omdb;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ruudschroen.proficiency.fundamentals.movies.Movie;
import com.ruudschroen.proficiency.fundamentals.movies.MovieData;
import com.ruudschroen.proficiency.fundamentals.movies.MovieRating;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.util.Arrays;

@Getter
@Accessors(fluent = true)
public class OmdbMovieDto implements MovieData {
    @JsonProperty("Title")
    private final String title;

    @JsonProperty("Year")
    private final String year;

    @JsonProperty("Rated")
    private final String rated;

    @JsonProperty("Released")
    private final String released;

    @JsonProperty("Runtime")
    private final String runtime;

    @JsonProperty("Genre")
    private final String genre;

    @JsonProperty("Director")
    private final String director;

    @JsonProperty("Writer")
    private final String writer;

    @JsonProperty("Actors")
    private final String actors;

    @JsonProperty("Plot")
    private final String plot;

    @JsonProperty("Language")
    private final String language;

    @JsonProperty("Country")
    private final String country;

    @JsonProperty("Awards")
    private final String awards;

    @JsonProperty("Poster")
    private final String poster;

    @JsonProperty("Ratings")
    private final OmdbMovieRatingDto[] ratings;

    @JsonProperty("Metascore")
    private final String metascore;

    @JsonProperty("imdbRating")
    private final String imdbRating;

    @JsonProperty("imdbVotes")
    private final String imdbVotes;

    @JsonProperty("imdbID")
    private final String imdbID;

    @JsonProperty("Type")
    private final String type;

    @JsonProperty("DVD")
    private final String dvd;

    @JsonProperty("BoxOffice")
    private final String boxOffice;

    @JsonProperty("Production")
    private final String production;

    @JsonProperty("Website")
    private final String website;

    @JsonProperty("Response")
    private final String response;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public OmdbMovieDto(
            @JsonProperty("Title") String title,
            @JsonProperty("Year") String year,
            @JsonProperty("Rated") String rated,
            @JsonProperty("Released") String released,
            @JsonProperty("Runtime") String runtime,
            @JsonProperty("Genre") String genre,
            @JsonProperty("Director") String director,
            @JsonProperty("Writer") String writer,
            @JsonProperty("Actors") String actors,
            @JsonProperty("Plot") String plot,
            @JsonProperty("Language") String language,
            @JsonProperty("Country") String country,
            @JsonProperty("Awards") String awards,
            @JsonProperty("Poster") String poster,
            @JsonProperty("Ratings") OmdbMovieRatingDto[] ratings,
            @JsonProperty("Metascore") String metascore,
            @JsonProperty("imdbRating") String imdbRating,
            @JsonProperty("imdbVotes") String imdbVotes,
            @JsonProperty("imdbID") String imdbID,
            @JsonProperty("Type") String type,
            @JsonProperty("DVD") String dvd,
            @JsonProperty("BoxOffice") String boxOffice,
            @JsonProperty("Production") String production,
            @JsonProperty("Website") String website,
            @JsonProperty("Response") String response) {
        this.title = title;
        this.year = year;
        this.rated = rated;
        this.released = released;
        this.runtime = runtime;
        this.genre = genre;
        this.director = director;
        this.writer = writer;
        this.actors = actors;
        this.plot = plot;
        this.language = language;
        this.country = country;
        this.awards = awards;
        this.poster = poster;
        this.ratings = ratings;
        this.metascore = metascore;
        this.imdbRating = imdbRating;
        this.imdbVotes = imdbVotes;
        this.imdbID = imdbID;
        this.type = type;
        this.dvd = dvd;
        this.boxOffice = boxOffice;
        this.production = production;
        this.website = website;
        this.response = response;
    }

    public Movie toMovie() {
        MovieRating[] ratings = Arrays.stream(this.ratings)
                .map(OmdbMovieRatingDto::toMovieRating)
                .toArray(MovieRating[]::new);

        return new Movie(
                title,
                year,
                rated,
                released,
                runtime,
                genre,
                director,
                writer,
                actors,
                plot,
                language,
                country,
                awards,
                poster,
                ratings,
                metascore,
                imdbRating,
                imdbVotes,
                imdbID,
                type,
                dvd,
                boxOffice,
                production,
                website,
                response);
    }
}
