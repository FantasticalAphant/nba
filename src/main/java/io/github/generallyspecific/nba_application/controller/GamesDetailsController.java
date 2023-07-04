package io.github.generallyspecific.nba_application.controller;

import io.github.generallyspecific.nba_application.model.GamesDetails;
import io.github.generallyspecific.nba_application.repository.GamesDetailsRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class GamesDetailsController {
    private final GamesDetailsRepository gamesDetailsRepository;

    public GamesDetailsController(GamesDetailsRepository gamesDetailsService) {
        this.gamesDetailsRepository = gamesDetailsService;
    }

    @GetMapping("/gamesdetails/{playerName}")
    public List<GamesDetails> getGamesDetailsByPlayerName(@PathVariable String playerName) {
        return this.gamesDetailsRepository.findLatestGamesDetailsByPlayerName(playerName);
    }
}
