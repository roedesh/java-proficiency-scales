package com.ruudschroen.proficiency.novice.movies;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ruudschroen.proficiency.novice.movies.omdb.OmdbMovieService;

@RestController
@RequestMapping("movie")
public class MovieController {
    static final String IMDB_ID = "tt1745960"; // Top Gun: Maverick

    private final OmdbMovieService movieService;

    public MovieController(OmdbMovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Movie get() {
        try {
            return movieService.getMovieByImdbID(IMDB_ID);
        } catch (MovieServiceException e) {
            e.printStackTrace();
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Failed to retrieve movie", e);
        }
    }
}
