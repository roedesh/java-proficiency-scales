package com.ruudschroen.proficiency.intermediate.movies;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ruudschroen.proficiency.intermediate.movies.omdb.OmdbMovieService;

@RestController
@RequestMapping("movie")
public class MovieController {
    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
    private static final String IMDB_ID = "tt1745960"; // Top Gun: Maverick

    private final OmdbMovieService movieService;

    public MovieController(OmdbMovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Movie get() {
        try {
            return movieService.getMovieByImdbID(IMDB_ID);
        } catch (MovieServiceException e) {
            logger.error("An exception occured in GET /movie!", e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Failed to retrieve movie", e);
        }
    }
}
