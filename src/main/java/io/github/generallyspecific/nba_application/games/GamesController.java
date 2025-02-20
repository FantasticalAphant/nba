package io.github.generallyspecific.nba_application.games;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class GamesController {
    private final GamesRepository gamesRepository;

    public GamesController(GamesRepository gamesRepository) {
        this.gamesRepository = gamesRepository;
    }

    @GetMapping("/games/{date}")
    public List<GameInfoDTO> getGamesByDate(@PathVariable LocalDate date) {
        return gamesRepository.findGameInfoByGameDateEST(date);
    }

    @GetMapping("/game/{gameId}")
    public Games getGameByGameId(@PathVariable int gameId) {
        return gamesRepository.findGameByGameId(gameId);
    }

    @GetMapping("games/team/{teamId}")
    public List<GameInfoDTO> getGamesById(@PathVariable int teamId) {
        return gamesRepository.findGameInfoByGameId(teamId);
    }

    @GetMapping("games/team/{teamId}/{season}")
    public List<GameInfoDTO> getGamesByIdAndSeason(@PathVariable int teamId, @PathVariable short season) {
        return gamesRepository.findGameInfoByGameIdAndSeason(teamId, season);
    }
}
