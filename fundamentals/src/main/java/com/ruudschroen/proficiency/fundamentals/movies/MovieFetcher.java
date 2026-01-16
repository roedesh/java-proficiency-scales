package com.ruudschroen.proficiency.fundamentals.movies;

public interface MovieFetcher {
    public Movie getMovieByImdbID(String imdbId) throws MovieFetcherException;
}
