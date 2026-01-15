package com.ruudschroen;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.assertj.core.api.Assertions.assertThat;

public class MovieServiceTest {
    @Mock
    private HttpClient httpClient;

    @Mock
    private HttpResponse<String> httpResponse;

    @Test
    void retrievesMovie() throws IOException, InterruptedException {
        MockitoAnnotations.openMocks(this);
        MovieService movieService = new MovieService(httpClient);

        when(httpResponse.statusCode()).thenReturn(200);
        when(httpResponse.body()).thenReturn(
                "{\"Title\":\"Top Gun: Maverick\",\"Year\":\"2022\",\"Rated\":\"PG-13\",\"Released\":\"27 May 2022\",\"Runtime\":\"130 min\",\"Genre\":\"Action, Drama\",\"Director\":\"Joseph Kosinski\",\"Writer\":\"Jim Cash, Jack Epps Jr., Peter Craig\",\"Actors\":\"Tom Cruise, Jennifer Connelly, Miles Teller\",\"Plot\":\"The story involves Maverick confronting his past while training a group of younger Top Gun graduates, including the son of his deceased best friend, for a dangerous mission.\",\"Language\":\"English\",\"Country\":\"United States\",\"Awards\":\"Won 1 Oscar. 111 wins & 237 nominations total\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BMDBkZDNjMWEtOTdmMi00NmExLTg5MmMtNTFlYTJlNWY5YTdmXkEyXkFqcGc@._V1_SX300.jpg\",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"8.2/10\"},{\"Source\":\"Rotten Tomatoes\",\"Value\":\"96%\"},{\"Source\":\"Metacritic\",\"Value\":\"78/100\"}],\"Metascore\":\"78\",\"imdbRating\":\"8.2\",\"imdbVotes\":\"836,462\",\"imdbID\":\"tt1745960\",\"Type\":\"movie\",\"DVD\":\"N/A\",\"BoxOffice\":\"$718,732,821\",\"Production\":\"N/A\",\"Website\":\"N/A\",\"Response\":\"True\"}");

        // Match any HttpRequest and the specific BodyHandler type
        when(httpClient.send(
                any(HttpRequest.class),
                eq(HttpResponse.BodyHandlers.ofString())))
                .thenReturn(httpResponse);

        try {
            Movie movie = movieService.getByImdbId("tt1745960");
            assertThat(movie.getTitle()).isEqualTo("Top Gun: Maverick");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
