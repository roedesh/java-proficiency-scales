
package com.ruudschroen.proficiency.novice.movies.omdb;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ruudschroen.proficiency.novice.movies.Movie;
import com.ruudschroen.proficiency.novice.movies.MovieService;
import com.ruudschroen.proficiency.novice.movies.MovieServiceException;

import tools.jackson.databind.ObjectMapper;

@Service
public class OmdbMovieService implements MovieService {
    private static Logger logger = LoggerFactory.getLogger(OmdbMovieService.class);
    static final String OMDB_API_KEY = "f9d9aca";

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public OmdbMovieService(HttpClient httpClient, ObjectMapper objectMapper) {
        this.httpClient = httpClient;
        this.objectMapper = objectMapper;
    }

    @Override
    public Movie getMovieByImdbID(String imdbId) throws MovieServiceException {
        URI uri = URI.create(String.format("https://www.omdbapi.com/?apikey=%s&i=%s", OMDB_API_KEY, imdbId));

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .build();
        HttpResponse<String> response;

        try {
            logger.info("Performing GET request on {}", uri.toURL());
            response = httpClient.send(request, BodyHandlers.ofString());
            logger.info("Successfully received response!");
        } catch (IOException | InterruptedException e) {
            throw new MovieServiceException(e.getMessage());
        }

        OmdbMovieDto omdbMovieDto = objectMapper.readValue(response.body(), OmdbMovieDto.class);
        return omdbMovieDto.toMovie();
    }
}