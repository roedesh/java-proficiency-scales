package com.ruudschroen.proficiency.novice.movies;

public interface MovieService {
    Movie getMovieByImdbID(String imdbId) throws MovieServiceException;
}
