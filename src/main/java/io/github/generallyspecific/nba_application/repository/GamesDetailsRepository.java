package io.github.generallyspecific.nba_application.repository;

import io.github.generallyspecific.nba_application.model.GamesDetails;
import io.github.generallyspecific.nba_application.model.GamesDetailsIdKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GamesDetailsRepository extends JpaRepository<GamesDetails, GamesDetailsIdKey> {
    @Query("SELECT gd FROM GamesDetails gd JOIN Players p ON gd.playerId = p.playerId WHERE p.playerName = :playerName")
    List<GamesDetails> getPlayerGameDetails(@Param("playerName") String playerName);
}