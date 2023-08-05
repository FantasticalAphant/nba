package io.github.generallyspecific.nba_application.games;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface GamesRepository extends JpaRepository<Games, Integer> {
    List<Games> findGamesByGameDateEST(LocalDate date);

    Games findGameByGameId(int gameId);

    List<Games> findGamesByHomeTeamIdOrVisitorTeamIdOrderByGameDateESTDesc(int homeTeamId, int visitorTeamId);

    // Retrieve GameInfoDTO objects by teamId
    // TODO: always return home team in the correct position
    @Query("SELECT new io.github.generallyspecific.nba_application.games.GameInfoDTO(g, CONCAT(ht.city, ' ', ht.nickname), CONCAT(vt.city, ' ', vt.nickname)) " +
            "FROM Games g " +
            "JOIN Teams ht ON g.homeTeamId = ht.teamId " +
            "JOIN Teams vt ON g.visitorTeamId = vt.teamId " +
            "WHERE g.homeTeamId = ?1 OR g.visitorTeamId = ?1 " +
            "ORDER BY g.gameDateEST DESC")
    List<GameInfoDTO> findGameInfoByGameId(int teamId);

    // Retrieve GameInfoDTO objects by teamId and season
    @Query("SELECT new io.github.generallyspecific.nba_application.games.GameInfoDTO(g, CONCAT(ht.city, ' ', ht.nickname), CONCAT(vt.city, ' ', vt.nickname)) " +
            "FROM Games g " +
            "JOIN Teams ht ON g.homeTeamId = ht.teamId " +
            "JOIN Teams vt ON g.visitorTeamId = vt.teamId " +
            "WHERE (g.homeTeamId = ?1 OR g.visitorTeamId = ?1) AND g.season = ?2 " +
            "ORDER BY g.gameDateEST DESC")
    List<GameInfoDTO> findGameInfoByGameIdAndSeason(int teamId, short season);
}
