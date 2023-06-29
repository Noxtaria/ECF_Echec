package com.example.ecf3echec;

import com.example.ecf3echec.controller.HomeController;
import com.example.ecf3echec.entity.Matches;
import com.example.ecf3echec.service.MatchService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HomeController.class)
public class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MatchService matchService;

    @Test
    public void testHomePage() throws Exception {
        Matches matches1 = new Matches("Player 1", "Player 2", "Result 1");
        Matches matches2 = new Matches("Player 3", "Player 4", "Result 2");
        List<Matches> upcomingMatches = Arrays.asList(matches1, matches2);

        when(matchService.getUpcomingMatches()).thenReturn(upcomingMatches);

        ResultActions result = mockMvc.perform(get("/"));

        result.andExpect(status().isOk())
                .andExpect(view().name("home"))
                .andExpect(content().string(containsString("Prochains matches")))
                .andExpect(content().string(containsString("Résultats des matches précédents")))
                .andExpect(model().attribute("upcomingMatches", upcomingMatches));
    }
}
