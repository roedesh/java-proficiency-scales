package com.ruudschroen;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Movie {
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
    private final MovieRating[] ratings;
    private final String metascore;
    private final String imdbRating;
    private final String imdbVotes;
    private final String imdbId;
    private final String type;
    private final String dvd;
    private final String boxOffice;
    private final String production;
    private final String website;
    private final String response;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public Movie(@JsonProperty("Title") String title, @JsonProperty("Year") String year,
            @JsonProperty("Rated") String rated, @JsonProperty("Released") String released,
            @JsonProperty("Runtime") String runtime, @JsonProperty("Genre") String genre,
            @JsonProperty("Director") String director, @JsonProperty("Writer") String writer,
            @JsonProperty("Actors") String actors, @JsonProperty("Plot") String plot,
            @JsonProperty("Language") String language, @JsonProperty("Country") String country,
            @JsonProperty("Awards") String awards,
            @JsonProperty("Poster") String poster, @JsonProperty("Ratings") MovieRating[] ratings,
            @JsonProperty("Metascore") String metascore, @JsonProperty("imdbRating") String imdbRating,
            @JsonProperty("imdbVotes") String imdbVotes, @JsonProperty("imdbID") String imdbId,
            @JsonProperty("Type") String type, @JsonProperty("DVD") String dvd,
            @JsonProperty("BoxOffice") String boxOffice, @JsonProperty("Production") String production,
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
        this.imdbId = imdbId;
        this.type = type;
        this.dvd = dvd;
        this.boxOffice = boxOffice;
        this.production = production;
        this.website = website;
        this.response = response;
    }

    @JsonProperty("Title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("Year")
    public String getYear() {
        return year;
    }

    @JsonProperty("Rated")
    public String getRated() {
        return rated;
    }

    @JsonProperty("Released")
    public String getReleased() {
        return released;
    }

    @JsonProperty("Runtime")
    public String getRuntime() {
        return runtime;
    }

    @JsonProperty("Genre")
    public String getGenre() {
        return genre;
    }

    @JsonProperty("Director")
    public String getDirector() {
        return director;
    }

    @JsonProperty("Writer")
    public String getWriter() {
        return writer;
    }

    @JsonProperty("Actors")
    public String getActors() {
        return actors;
    }

    @JsonProperty("Plot")
    public String getPlot() {
        return plot;
    }

    @JsonProperty("Language")
    public String getLanguage() {
        return language;
    }

    @JsonProperty("Country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("Awards")
    public String getAwards() {
        return awards;
    }

    @JsonProperty("Poster")
    public String getPoster() {
        return poster;
    }

    @JsonProperty("Ratings")
    public MovieRating[] getRatings() {
        return ratings;
    }

    @JsonProperty("Metascore")
    public String getMetascore() {
        return metascore;
    }

    @JsonProperty("imdbRating")
    public String getImdbRating() {
        return imdbRating;
    }

    @JsonProperty("imdbVotes")
    public String getImdbVotes() {
        return imdbVotes;
    }

    @JsonProperty("imdbID")
    public String getImdbId() {
        return imdbId;
    }

    @JsonProperty("Type")
    public String getType() {
        return type;
    }

    @JsonProperty("DVD")
    public String getDvd() {
        return dvd;
    }

    @JsonProperty("BoxOffice")
    public String getBoxOffice() {
        return boxOffice;
    }

    @JsonProperty("Production")
    public String getProduction() {
        return production;
    }

    @JsonProperty("Website")
    public String getWebsite() {
        return website;
    }

    @JsonProperty("Response")
    public String getResponse() {
        return response;
    }

}
