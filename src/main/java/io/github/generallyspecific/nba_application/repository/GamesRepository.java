package io.github.generallyspecific.nba_application.repository;

import io.github.generallyspecific.nba_application.model.games.Games;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface GamesRepository extends JpaRepository<Games, Integer> {
    List<Games> findGamesByGameDateEST(LocalDate date);

    Games findGameByGameID(int gameId);

    List<Games> findGamesByHomeTeamIDOrVisitorTeamIDOrderByGameDateESTDesc(int homeTeamId, int visitorTeamId);
}
