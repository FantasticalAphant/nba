package io.github.generallyspecific.nba_application.teams;

import io.github.generallyspecific.nba_application.teams.Teams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamsRepository extends JpaRepository<Teams, Long> {
    Teams findTeamsByNickname(String nickname);
    Teams findTeamsByTeamId(long teamId);
}
