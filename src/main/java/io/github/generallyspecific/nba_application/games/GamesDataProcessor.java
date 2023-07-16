package io.github.generallyspecific.nba_application.games;

import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDate;

public class GamesDataProcessor implements ItemProcessor<GamesInput, Games> {

    @Override
    public Games process(final GamesInput gamesInput) throws Exception {
        Games game = new Games();

        game.setGameDateEST(LocalDate.parse(gamesInput.getGame_date_est()));
        game.setGameId(Integer.parseInt(gamesInput.getGame_id()));
        game.setGameStatusText(gamesInput.getGame_status_text());

        game.setHomeTeamId(Integer.parseInt(gamesInput.getHome_team_id()));
        game.setVisitorTeamId(Integer.parseInt(gamesInput.getVisitor_team_id()));
        game.setSeason(Short.parseShort(gamesInput.getSeason()));

        game.setTeamIdHome(Integer.parseInt(gamesInput.getTeam_id_home()));
        game.setPtsHome((short)Double.parseDouble(gamesInput.getPts_home()));
        game.setFgPctHome(Double.parseDouble(gamesInput.getFg_pct_home()));
        game.setFtPctHome(Double.parseDouble(gamesInput.getFt_pct_home()));
        game.setFg3PctHome(Double.parseDouble(gamesInput.getFg3_pct_home()));
        game.setAstHome((byte)Double.parseDouble(gamesInput.getAst_home()));
        game.setRebHome((byte)Double.parseDouble(gamesInput.getReb_home()));

        game.setTeamIdAway(Integer.parseInt(gamesInput.getTeam_id_away()));
        game.setPtsAway((short)Double.parseDouble(gamesInput.getPts_away()));
        game.setFgPctAway(Double.parseDouble(gamesInput.getFg_pct_away()));
        game.setFtPctAway(Double.parseDouble(gamesInput.getFt_pct_away()));
        game.setFg3PctAway(Double.parseDouble(gamesInput.getFg3_pct_away()));
        game.setAstAway((byte)Double.parseDouble(gamesInput.getAst_away()));
        game.setRebAway((byte)Double.parseDouble(gamesInput.getReb_away()));

        game.setHomeTeamWins(Byte.parseByte(gamesInput.getHome_team_wins()));

        return game;
    }

}