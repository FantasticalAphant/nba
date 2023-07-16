package io.github.generallyspecific.nba_application.stats;

import io.github.generallyspecific.nba_application.stats.GamesDetails;
import io.github.generallyspecific.nba_application.stats.GamesDetailsRepository;
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

    // maybe also search for team id (to group by team)
    @GetMapping("/gamesdetails/game/{gameId}")
    public List<GamesDetails> getGamesDetailsByGameId(@PathVariable int gameId) {
        return this.gamesDetailsRepository.getGamesDetailsByGameId(gameId);
    }
}
