package com.ruudschroen;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tools.jackson.databind.ObjectMapper;

public class Main {
    static final String OMDB_API_KEY = "f9d9aca";
    static final String IMDB_ID = "tt1745960"; // Top Gun: Maverick

    public static void main(String[] args) {
        final Logger logger = LoggerFactory.getLogger(Main.class);

        ObjectMapper objectMapper = new ObjectMapper();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("https://www.omdbapi.com/?apikey=%s&i=%s", OMDB_API_KEY, IMDB_ID)))
                .build();

        try {
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            Movie movie = objectMapper.readValue(response.body(), Movie.class);
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