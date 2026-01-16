package com.ruudschroen.proficiency.fundamentals.movies;

public interface MovieData {
    String title();
    String year();
    String rated();
    String released();
    String runtime();
    String genre();
    String director();
    String writer();
    String actors();
    String plot();
    String language();
    String country();
    String awards();
    String poster();
    MovieRatingData[] ratings();
    String metascore();
    String imdbRating();
    String imdbVotes();
    String imdbID();
    String type();
    String dvd();
    String boxOffice();
    String production();
    String website();
    String response();
}
