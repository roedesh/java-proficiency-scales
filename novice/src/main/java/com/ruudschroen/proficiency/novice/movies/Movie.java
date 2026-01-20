package com.ruudschroen.proficiency.novice.movies;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Movie {
    private final String title;
    private final String year;
    private final String rated;
    private final String released;
    private final String runtime;
    private final String[] genres;
    private final String director;
    private final String[] writers;
    private final String[] actors;
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
    public Movie(String title, String year,
            String rated, String released,
            String runtime, String[] genres,
            String director, String[] writers,
            String[] actors, String plot,
            String language, String country,
            String awards,
            String poster, MovieRating[] ratings,
            String metascore, String imdbRating,
            String imdbVotes, String imdbId,
            String type, String dvd,
            String boxOffice, String production,
            String website,
            String response) {
        this.title = title;
        this.year = year;
        this.rated = rated;
        this.released = released;
        this.runtime = runtime;
        this.genres = genres;
        this.director = director;
        this.writers = writers;
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

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("year")
    public String getYear() {
        return year;
    }

    @JsonProperty("rated")
    public String getRated() {
        return rated;
    }

    @JsonProperty("released")
    public String getReleased() {
        return released;
    }

    @JsonProperty("runtime")
    public String getRuntime() {
        return runtime;
    }

    @JsonProperty("genres")
    public String[] getGenres() {
        return genres;
    }

    @JsonProperty("director")
    public String getDirector() {
        return director;
    }

    @JsonProperty("writers")
    public String[] getWriters() {
        return writers;
    }

    @JsonProperty("actors")
    public String[] getActors() {
        return actors;
    }

    @JsonProperty("plot")
    public String getPlot() {
        return plot;
    }

    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("awards")
    public String getAwards() {
        return awards;
    }

    @JsonProperty("poster")
    public String getPoster() {
        return poster;
    }

    @JsonProperty("ratings")
    public MovieRating[] getRatings() {
        return ratings;
    }

    @JsonProperty("metascore")
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

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("dvd")
    public String getDvd() {
        return dvd;
    }

    @JsonProperty("boxOffice")
    public String getBoxOffice() {
        return boxOffice;
    }

    @JsonProperty("production")
    public String getProduction() {
        return production;
    }

    @JsonProperty("website")
    public String getWebsite() {
        return website;
    }

    @JsonProperty("response")
    public String getResponse() {
        return response;
    }
}
