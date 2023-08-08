package io.github.generallyspecific.nba_application.players;

import io.github.generallyspecific.nba_application.players.Players;
import io.github.generallyspecific.nba_application.players.PlayersIdKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.repository.query.Param;

@Repository
public interface PlayersRepository extends JpaRepository<Players, PlayersIdKey> {
    // could potentially return multiple players with the same name
    List<Players> findByPlayerName(String playerName);

    // players list only goes up to 2019 season
    List<Players> findByTeamIdAndSeasonOrderByPlayerName(int teamId, int season);

    // query database for players with the user-provided query string in their name while removing duplicates with the same name and id
    @Query("SELECT p FROM Players p WHERE LOWER(p.playerName) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<Players> search(@Param("query") String query);

}
