package com.ruudschroen.proficiency.fundamentals.movies.omdb;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ruudschroen.proficiency.fundamentals.Main;
import com.ruudschroen.proficiency.fundamentals.movies.Movie;
import com.ruudschroen.proficiency.fundamentals.movies.MovieFetcher;
import com.ruudschroen.proficiency.fundamentals.movies.MovieFetcherException;

import tools.jackson.databind.ObjectMapper;

public class OmdbMovieFetcher implements MovieFetcher {
    private static Logger logger = LoggerFactory.getLogger(OmdbMovieFetcher.class);

    private final String apiKey;

    public OmdbMovieFetcher(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public Movie getMovieByImdbID(String imdbId) throws MovieFetcherException {
        URI uri = URI.create(String.format("https://www.omdbapi.com/?apikey=%s&i=%s", apiKey, imdbId));

        ObjectMapper objectMapper = new ObjectMapper();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .build();
        HttpResponse<String> response;

        try {
            logger.info("Performing GET request on {}", uri.toURL());
            response = client.send(request, BodyHandlers.ofString());
            logger.info("Successfully received response!");
        } catch (IOException | InterruptedException e) {
            throw new MovieFetcherException(e.getMessage());
        }

        OmdbMovieDto omdbMovieDto = objectMapper.readValue(response.body(), OmdbMovieDto.class);
        return omdbMovieDto.toMovie();
    }
}
