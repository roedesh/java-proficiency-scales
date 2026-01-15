package com.ruudschroen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import org.springframework.stereotype.Component;

@Component
public class StartupRunner implements ApplicationRunner {
    static final String IMDB_ID = "tt1745960"; // Top Gun: Maverick

    private final MovieService movieService;

    public StartupRunner(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        final Logger logger = LoggerFactory.getLogger(Main.class);

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