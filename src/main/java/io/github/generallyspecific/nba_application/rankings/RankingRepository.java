package io.github.generallyspecific.nba_application.rankings;

import io.github.generallyspecific.nba_application.rankings.Ranking;
import io.github.generallyspecific.nba_application.rankings.RankingIdKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RankingRepository extends JpaRepository<Ranking, RankingIdKey> {
    // also group by conference
    List<Ranking> findRankingByStandingsDate(LocalDate standingsDate);
}
