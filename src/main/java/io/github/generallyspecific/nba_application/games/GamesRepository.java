package io.github.generallyspecific.nba_application.games;

import io.github.generallyspecific.nba_application.games.Games;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface GamesRepository extends JpaRepository<Games, Integer> {
    List<Games> findGamesByGameDateEST(LocalDate date);

    Games findGameByGameId(int gameId);

    List<Games> findGamesByHomeTeamIdOrVisitorTeamIdOrderByGameDateESTDesc(int homeTeamId, int visitorTeamId);
}
