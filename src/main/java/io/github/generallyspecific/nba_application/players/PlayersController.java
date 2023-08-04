package io.github.generallyspecific.nba_application.players;

import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/players/{teamId}")
    List<Players> findByTeamIdAndSeason(@PathVariable int teamId, @RequestParam(required=false) String season) {

        if (season == null) {
            // return all players from the most recent season
            // TODO: don't hardcode value
            return this.playersRepository.findByTeamIdAndSeasonOrderByPlayerName(teamId, 2019);
        } else {
            // return all players from the specified season
            return this.playersRepository.findByTeamIdAndSeasonOrderByPlayerName(teamId, Integer.parseInt(season));
        }
    }

}
