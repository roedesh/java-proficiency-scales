package com.ruudschroen;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.springframework.stereotype.Service;

import tools.jackson.databind.ObjectMapper;

@Service
public class MovieService {
    static final String OMDB_API_KEY = "f9d9aca";

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public MovieService(HttpClient httpClient, ObjectMapper objectMapper) {
        this.httpClient = httpClient;
        this.objectMapper = objectMapper;
    }

    public Movie getByImdbId(String imdbId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("https://www.omdbapi.com/?apikey=%s&i=%s", OMDB_API_KEY, imdbId)))
                .build();

        HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
        return objectMapper.readValue(response.body(), Movie.class);
    }
}
