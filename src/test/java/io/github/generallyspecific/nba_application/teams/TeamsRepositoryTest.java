package io.github.generallyspecific.nba_application.teams;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class TeamsRepositoryTest {
    @Autowired
    private TeamsRepository teamsRepository;

    @Test
    public void testFindAll() {
        Iterable<Teams> teams = teamsRepository.findAll();
        assert(teams.iterator().hasNext());
    }

    @Test
    public void testFindTeamsByNickname() {
        Teams teams = teamsRepository.findTeamsByNickname("Lakers");
        assert(teams.getTeamId() == 14);
    }

}
