package io.github.generallyspecific.nba_application.players;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// maybe use @RequestMapping to set the base path
@RestController
@CrossOrigin(origins="http://localhost:3000")
public class PlayersController {

    private final PlayersRepository playersRepository;

    public PlayersController(PlayersRepository playersRepository) {
        this.playersRepository = playersRepository;
    }

    @GetMapping("/player/{playerName}")
    public Players getPlayer(@PathVariable String playerName) {
//        // TODO: handle cases where the name is not found
//        // TODO: make the name case insensitive
//        Players players = this.playersRepository.findByPlayerName(playerName).get(0);
//        // TODO: get the date of the game from the gameid
//        players.setGamesDetails(this.gamesDetailsRepository.getGamesDetailsByPlayerName(playerName));
//
//        return players;

        return this.playersRepository.findByPlayerName(playerName).get(0);
    }

    // add method to get all players from a specific team in a specific season
    // TODO: maybe use a query instead of path parameter for season
    @GetMapping("/players/{teamId}/{season}")
    List<Players> findByTeamIdAndSeason(@PathVariable int teamId, @PathVariable int season) {
        return this.playersRepository.findByTeamIdAndSeasonOrderByPlayerName(teamId, season);
    }

}
