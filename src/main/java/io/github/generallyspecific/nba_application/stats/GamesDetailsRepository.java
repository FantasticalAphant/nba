package io.github.generallyspecific.nba_application.stats;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GamesDetailsRepository extends JpaRepository<GamesDetails, GamesDetailsIdKey> {
    @Query("SELECT gd FROM GamesDetails gd JOIN Players p ON gd.playerId = p.playerId WHERE p.playerName = :playerName ORDER BY gd.gameId DESC")
    List<GamesDetails> getPlayerGameDetails(@Param("playerName") String playerName);

    List<GamesDetails> getGamesDetailsByGameId(int gameId);

    default List<GamesDetails> findLatestGamesDetailsByPlayerName(String playerName) {
        return getPlayerGameDetails(playerName);
    }
}