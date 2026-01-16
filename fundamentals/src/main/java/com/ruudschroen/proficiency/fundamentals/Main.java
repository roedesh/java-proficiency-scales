package com.ruudschroen.proficiency.fundamentals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ruudschroen.proficiency.fundamentals.movies.Movie;
import com.ruudschroen.proficiency.fundamentals.movies.MovieFetcherException;
import com.ruudschroen.proficiency.fundamentals.movies.MovieRating;
import com.ruudschroen.proficiency.fundamentals.movies.omdb.OmdbMovieFetcher;

public class Main {
    static final String OMDB_API_KEY = "f9d9aca";
    static final String IMDB_ID = "tt1745960"; // Top Gun: Maverick
    static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        OmdbMovieFetcher movieFetcher = new OmdbMovieFetcher(OMDB_API_KEY);
        try {
            Movie movie = movieFetcher.getMovieByImdbID(IMDB_ID);
            logger.info("The movie \"{}\" has an IMDB rating of {}", movie.title(), movie.imdbRating());
            logger.info("It received the following ratings from critics:");
            for (MovieRating rating : movie.ratings()) {
                logger.info("   *  {} {}", rating.name(), rating.score());
            }
        } catch (MovieFetcherException e) {
            e.printStackTrace();
        }
    }
}