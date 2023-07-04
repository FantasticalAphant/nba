package io.github.generallyspecific.nba_application.controller;

import io.github.generallyspecific.nba_application.model.games.Games;
import io.github.generallyspecific.nba_application.repository.GamesRepository;
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
    public List<Games> getGamesByDate(@PathVariable LocalDate date) {
        return gamesRepository.findGamesByGameDateEST(date);
    }

    @GetMapping("/game/{gameId}")
    public Games getGameByGameId(@PathVariable int gameId) {
        return gamesRepository.findGameByGameID(gameId);
    }

}
