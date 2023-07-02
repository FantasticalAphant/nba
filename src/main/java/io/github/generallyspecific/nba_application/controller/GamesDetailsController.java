package io.github.generallyspecific.nba_application.controller;

import io.github.generallyspecific.nba_application.model.GamesDetails;
import io.github.generallyspecific.nba_application.service.GamesDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GamesDetailsController {
    private final GamesDetailsService gamesDetailsService;

    public GamesDetailsController(GamesDetailsService gamesDetailsService) {
        this.gamesDetailsService = gamesDetailsService;
    }

    @GetMapping("/gamesdetails/{playerName}")
    public List<GamesDetails> getGamesDetailsByPlayerName(@PathVariable String playerName) {
        return this.gamesDetailsService.getGamesDetailsByPlayerName(playerName);
    }
}
