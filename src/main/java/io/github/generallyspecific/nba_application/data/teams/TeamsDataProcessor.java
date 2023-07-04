package io.github.generallyspecific.nba_application.data.teams;

import io.github.generallyspecific.nba_application.model.teams.Teams;
import org.springframework.batch.item.ItemProcessor;

public class TeamsDataProcessor implements ItemProcessor<TeamsInput, Teams> {

    @Override
    public Teams process(final TeamsInput teamsInput) throws Exception {
        Teams team = new Teams();

        team.setTeamId(Long.parseLong(teamsInput.getTeam_id()));
        team.setMinYear(Integer.parseInt(teamsInput.getMin_year()));
        team.setMaxYear(Integer.parseInt(teamsInput.getMax_year()));
        team.setAbbreviation(teamsInput.getAbbreviation());
        team.setNickname(teamsInput.getNickname());
        team.setYearFounded(Integer.parseInt(teamsInput.getYear_founded()));
        team.setCity(teamsInput.getCity());
        team.setArena(teamsInput.getArena());
        team.setOwner(teamsInput.getOwner());
        team.setGeneralManager(teamsInput.getGeneral_manager());
        team.setHeadCoach(teamsInput.getHead_coach());

        return team;
    }

}
