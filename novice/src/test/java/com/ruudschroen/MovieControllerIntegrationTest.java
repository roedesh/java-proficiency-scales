package com.ruudschroen;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.ruudschroen.proficiency.novice.movies.MovieController;
import com.ruudschroen.proficiency.novice.movies.omdb.OmdbMovieService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = MovieController.class)
public class MovieControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private OmdbMovieService movieService;

    @Test
    void returns200() throws Exception {
        mockMvc.perform(get("/movie")
                .contentType("application/json"))
                .andExpect(status().isOk());
    }
}
