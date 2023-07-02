package io.github.generallyspecific.nba_application.repository;

import io.github.generallyspecific.nba_application.model.Players;
import io.github.generallyspecific.nba_application.model.PlayersIdKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayersRepository extends JpaRepository<Players, PlayersIdKey> {
    // could potentially return multiple players with the same name
    List<Players> findByPlayerName(String playerName);
}
