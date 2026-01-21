package com.ruudschroen.proficiency.novice.movies.omdb;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ruudschroen.proficiency.novice.movies.Movie;
import com.ruudschroen.proficiency.novice.movies.MovieDto;
import com.ruudschroen.proficiency.novice.movies.MovieRating;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.util.Arrays;

@Getter
@Accessors(fluent = true)
public class OmdbMovieDto implements MovieDto {
    private final String title;

    private final String year;

    private final String rated;

    private final String released;

    private final String runtime;

    private final String genre;

    private final String director;

    private final String writer;

    private final String actors;

    private final String plot;

    private final String language;

    private final String country;

    private final String awards;

    private final String poster;

    private final OmdbMovieRatingDto[] ratings;

    private final String metascore;

    private final String imdbRating;

    private final String imdbVotes;

    private final String imdbID;

    private final String type;

    private final String dvd;

    private final String boxOffice;

    private final String production;

    private final String website;

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
        final MovieRating[] ratings = Arrays.stream(this.ratings)
                .map(OmdbMovieRatingDto::toMovieRating)
                .toArray(MovieRating[]::new);

        final String[] actorsList = actors.split("\\s*,\\s*");
        final String[] genres = genre.split("\\s*,\\s*");
        final String[] writers = writer.split("\\s*,\\s*");

        return new Movie(
                title,
                year,
                rated,
                released,
                runtime,
                genres,
                director,
                writers,
                actorsList,
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