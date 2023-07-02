package io.github.generallyspecific.nba_application.service;

import io.github.generallyspecific.nba_application.model.GamesDetails;
import io.github.generallyspecific.nba_application.repository.GamesDetailsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GamesDetailsService {
    private final GamesDetailsRepository gamesDetailsRepository;

    public GamesDetailsService(GamesDetailsRepository gamesDetailsRepository) {
        this.gamesDetailsRepository = gamesDetailsRepository;
    }

    public List<GamesDetails> getGamesDetailsByPlayerName(String playerName) {
        return this.gamesDetailsRepository.getPlayerGameDetails(playerName);
    }
}
