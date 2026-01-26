package com.ruudschroen.proficiency.intermediate.movies;

public interface MovieService {
    Movie getMovieByImdbID(String imdbId) throws MovieServiceException;
}
