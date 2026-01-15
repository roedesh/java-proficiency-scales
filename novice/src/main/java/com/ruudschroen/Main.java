package com.ruudschroen;

import java.net.http.HttpClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    static final String IMDB_ID = "tt1745960"; // Top Gun: Maverick

    public static void main(String[] args) {
        final Logger logger = LoggerFactory.getLogger(Main.class);
        MovieService movieService = new MovieService(HttpClient.newHttpClient());

        try {
            Movie movie = movieService.getByImdbId(IMDB_ID);
            logger.info("The movie \"{}\" has an IMDB rating of {}", movie.getTitle(), movie.getImdbRating());
            logger.info("It received the following ratings from critics:");
            for (MovieRating rating : movie.getRatings()) {
                logger.info("   *  {} {}", rating.getSource(), rating.getValue());
            }
        } catch (Exception e) {
            logger.error("An error occured: {}", e.getMessage());
            System.exit(1);
        }
    }
}