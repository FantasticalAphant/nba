package io.github.generallyspecific.nba_application.data.gamesdetails;

import io.github.generallyspecific.nba_application.model.gamesdetails.GamesDetails;
import org.springframework.batch.item.ItemProcessor;

public class GamesDetailsDataProcessor implements ItemProcessor<GamesDetailsInput, GamesDetails> {

    @Override
    public GamesDetails process(final GamesDetailsInput gamesDetailsInput) throws Exception {
        GamesDetails gamesDetails = new GamesDetails();
        gamesDetails.setGameId(Integer.parseInt(gamesDetailsInput.getGame_id()));
        gamesDetails.setTeamId(Integer.parseInt(gamesDetailsInput.getTeam_id()));
        gamesDetails.setTeamAbbreviation(gamesDetailsInput.getTeam_abbreviation());
        gamesDetails.setTeamCity(gamesDetailsInput.getTeam_city());
        gamesDetails.setPlayerId(Integer.parseInt(gamesDetailsInput.getPlayer_id()));
        gamesDetails.setPlayerName(gamesDetailsInput.getPlayer_name());
        gamesDetails.setNickname(gamesDetailsInput.getNickname());

        // all the following values are nullable
        if (gamesDetailsInput.getStart_position() != null && gamesDetailsInput.getStart_position().length() > 0) {
            gamesDetails.setStartPosition(Character.toUpperCase(gamesDetailsInput.getStart_position().charAt(0)));
        }
        if (gamesDetailsInput.getComment() != null && gamesDetailsInput.getComment().length() > 0) {
            gamesDetails.setComment(gamesDetailsInput.getComment());
        }
        if (gamesDetailsInput.getMin() != null && gamesDetailsInput.getMin().length() > 0) {
            gamesDetails.setMin(gamesDetailsInput.getMin());
        }
        if (gamesDetailsInput.getFgm() != null && gamesDetailsInput.getFgm().length() > 0) {
            gamesDetails.setFgm((byte)Double.parseDouble(gamesDetailsInput.getFgm()));
        }
        if (gamesDetailsInput.getFga() != null && gamesDetailsInput.getFga().length() > 0) {
            gamesDetails.setFga((byte)Double.parseDouble(gamesDetailsInput.getFga()));
        }
        if (gamesDetailsInput.getFg_pct() != null && gamesDetailsInput.getFg_pct().length() > 0) {
            gamesDetails.setFgPct(Double.parseDouble(gamesDetailsInput.getFg_pct()));
        }
        if (gamesDetailsInput.getFg3m() != null && gamesDetailsInput.getFg3m().length() > 0) {
            gamesDetails.setFg3m((byte)Double.parseDouble(gamesDetailsInput.getFg3m()));
        }
        if (gamesDetailsInput.getFg3a() != null && gamesDetailsInput.getFg3a().length() > 0) {
            gamesDetails.setFg3a((byte)Double.parseDouble(gamesDetailsInput.getFg3a()));
        }
        if (gamesDetailsInput.getFg3_pct() != null && gamesDetailsInput.getFg3_pct().length() > 0) {
            gamesDetails.setFg3Pct(Double.parseDouble(gamesDetailsInput.getFg3_pct()));
        }
        if (gamesDetailsInput.getFtm() != null && gamesDetailsInput.getFtm().length() > 0) {
            gamesDetails.setFtm((byte)Double.parseDouble(gamesDetailsInput.getFtm()));
        }
        if (gamesDetailsInput.getFta() != null && gamesDetailsInput.getFta().length() > 0) {
            gamesDetails.setFta((byte)Double.parseDouble(gamesDetailsInput.getFta()));
        }
        if (gamesDetailsInput.getFt_pct() != null && gamesDetailsInput.getFt_pct().length() > 0) {
            gamesDetails.setFtPct(Double.parseDouble(gamesDetailsInput.getFt_pct()));
        }
        if (gamesDetailsInput.getOreb() != null && gamesDetailsInput.getOreb().length() > 0) {
            gamesDetails.setOreb((byte)Double.parseDouble(gamesDetailsInput.getOreb()));
        }
        if (gamesDetailsInput.getDreb() != null && gamesDetailsInput.getDreb().length() > 0) {
            gamesDetails.setDreb((byte)Double.parseDouble(gamesDetailsInput.getDreb()));
        }
        if (gamesDetailsInput.getReb() != null && gamesDetailsInput.getReb().length() > 0) {
            gamesDetails.setReb((byte)Double.parseDouble(gamesDetailsInput.getReb()));
        }
        if (gamesDetailsInput.getAst() != null && gamesDetailsInput.getAst().length() > 0) {
            gamesDetails.setAst((byte)Double.parseDouble(gamesDetailsInput.getAst()));
        }
        if (gamesDetailsInput.getStl() != null && gamesDetailsInput.getStl().length() > 0) {
            gamesDetails.setStl((byte)Double.parseDouble(gamesDetailsInput.getStl()));
        }
        if (gamesDetailsInput.getBlk() != null && gamesDetailsInput.getBlk().length() > 0) {
            gamesDetails.setBlk((byte)Double.parseDouble(gamesDetailsInput.getBlk()));
        }
        if (gamesDetailsInput.getTo() != null && gamesDetailsInput.getTo().length() > 0) {
            gamesDetails.setTo((byte)Double.parseDouble(gamesDetailsInput.getTo()));
        }
        if (gamesDetailsInput.getPf() != null && gamesDetailsInput.getPf().length() > 0) {
            gamesDetails.setPf((byte)Double.parseDouble(gamesDetailsInput.getPf()));
        }
        if (gamesDetailsInput.getPts() != null && gamesDetailsInput.getPts().length() > 0) {
            gamesDetails.setPts((byte)Double.parseDouble(gamesDetailsInput.getPts()));
        }
        if (gamesDetailsInput.getPlus_minus() != null && gamesDetailsInput.getPlus_minus().length() > 0) {
            gamesDetails.setPlusMinus((byte)Double.parseDouble(gamesDetailsInput.getPlus_minus()));
        }

        return gamesDetails;
    }
}
