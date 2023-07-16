package io.github.generallyspecific.nba_application.players;

import io.github.generallyspecific.nba_application.players.Players;
import io.github.generallyspecific.nba_application.players.PlayersIdKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayersRepository extends JpaRepository<Players, PlayersIdKey> {
    // could potentially return multiple players with the same name
    List<Players> findByPlayerName(String playerName);

    // players list only goes up to 2019 season
    List<Players> findByTeamIdAndSeasonOrderByPlayerName(int teamId, int season);
}
