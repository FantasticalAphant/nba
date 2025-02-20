package io.github.generallyspecific.nba_application.teams;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class TeamsController {
    private final TeamsRepository teamsRepository;

    public TeamsController(TeamsRepository teamsRepository) {
        this.teamsRepository = teamsRepository;
    }

    @GetMapping("/teams")
    public Iterable<Teams> getAllTeams() {
        return this.teamsRepository.findAll();
    }

    @GetMapping("/team/{name}")
    public Teams getTeam(@PathVariable String name) {
        return this.teamsRepository.findTeamsByNickname(StringUtils.capitalize(name));
    }

    @GetMapping("/team/id/{id}")
    public Teams getTeamById(@PathVariable int id) {
        return this.teamsRepository.findTeamsByTeamId(id);
    }
}
