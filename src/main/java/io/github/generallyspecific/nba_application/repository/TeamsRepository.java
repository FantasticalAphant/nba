package io.github.generallyspecific.nba_application.repository;

import io.github.generallyspecific.nba_application.model.Teams;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamsRepository extends JpaRepository<Teams, Long> {
    Teams findTeamsByNickname(String nickname);
}
